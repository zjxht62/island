package com.zjx.island.controller;

import com.alibaba.fastjson.JSON;
import com.zjx.island.biz.activiti.examples.CallRequest;
import com.zjx.island.biz.activiti.examples.Content;
import com.zjx.island.biz.activiti.examples.Headers;
import com.zjx.island.biz.activiti.examples.SecurityUtil;
import io.swagger.annotations.Api;
import org.activiti.api.model.shared.model.VariableInstance;
import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.process.runtime.connector.Connector;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.Task;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.runtime.TaskRuntime;
import org.activiti.engine.TaskService;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * 测试activiti接口调用来流转状态
 *
 * @author trevor.zhao
 * @date 2020/3/25
 */
@RestController
@RequestMapping("/activiti")
public class ActivitiController {
    private static final Logger LOGGER = Logger.getLogger(ActivitiController.class);

    @Autowired
    private ProcessRuntime processRuntime;

    @Autowired
    private SecurityUtil securityUtil;

    @Autowired
    private TaskRuntime taskRuntime;

    @RequestMapping(value = "/getAllpProgress", method = RequestMethod.GET)
    @ResponseBody
    public void getAllProcesses() {
        securityUtil.logInAs("system");
        Page<ProcessDefinition> processDefinitionPage = processRuntime.processDefinitions(Pageable.of(0, 10));
        LOGGER.info("> 可获得的流程定义有: " + processDefinitionPage.getTotalItems());
        for (ProcessDefinition pd : processDefinitionPage.getContent()) {
            LOGGER.info("\t > 流程定义: " + pd);
        }
    }

    @RequestMapping(value = "/newProcessInstance")
    @ResponseBody
    public void processANewInstance() {
        securityUtil.logInAs("system");

        Content content = pickRandomString();
        Headers headers = new Headers("contentType", "application/json");
        CallRequest callRequest = new CallRequest("www.trustlife.com", "{empty}", false, headers);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy HH:mm:ss");

        LOGGER.info("> 开始新建ProcessInstance: " + content + " at " + formatter.format(new Date()));

        ProcessInstance processInstance = processRuntime.start(ProcessPayloadBuilder
            .start()
            .withProcessDefinitionKey("categorizeHumanProcess")
            .withName("Processing Content: " + content)
            .withVariable("content", content)
            .withVariable("callRequest", callRequest)
            .build());
        LOGGER.info(">>> 创建流程实例: " + processInstance);
    }

    @RequestMapping(value = "/getAllMyTasks", method = RequestMethod.GET)
    @ResponseBody
    public String getAllMyTasks() {
        securityUtil.logInAs("webb");
        Page<Task> tasks = taskRuntime.tasks(Pageable.of(0, 10));
        if (tasks.getTotalItems() > 0) {
            return JSON.toJSONString(tasks.getContent());
        } else {
            return null;
        }
    }


    @RequestMapping(value = "/checkAndWorkOnTasksWhenAvailable")
    @ResponseBody
    public void checkAndWorkOnTasksWhenAvailable() {
//        securityUtil.logInAs("system");
        securityUtil.logInAs("webb");

        Page<Task> tasks = taskRuntime.tasks(Pageable.of(0, 10));
        if (tasks.getTotalItems() > 0) {
            for (Task t : tasks.getContent()) {

                LOGGER.info("> 领取任务: " + t.getId());
                taskRuntime.claim(TaskPayloadBuilder.claim().withTaskId(t.getId()).build());

                List<VariableInstance> variables = taskRuntime.variables(TaskPayloadBuilder.variables().withTaskId(t.getId()).build());
                Iterator<VariableInstance> iterator = variables.iterator();
                while (iterator.hasNext()) {
                    VariableInstance variableInstance = iterator.next();
                    LOGGER.info("> 所有的变量有: " + variableInstance.getName());
                    if (variableInstance.getName().equals("callRequest")) {
                        CallRequest request = variableInstance.getValue();
                        LOGGER.info("> 任务中收到的要调用的接口信息: " + request);
                        LOGGER.info("> 调用接口请求url：" + request.getUrl());
                        LOGGER.info("> 调用接口请求body：" + request.getBody());
                        LOGGER.info("> 请求头：" + request.getHeaders());
                    }
                    if (variableInstance.getName().equals("content")) {
                        Content contentToProcess = variableInstance.getValue();
                        LOGGER.info("> 任务中收到的要批准的内容: " + contentToProcess);

                        if (contentToProcess.getBody().contains("activiti")) {
                            LOGGER.info("> 用户批准内容");
                            contentToProcess.setApproved(true);
                        } else {
                            LOGGER.info("> 用户丢弃内容");
                            contentToProcess.setApproved(false);
                        }
                        taskRuntime.complete(TaskPayloadBuilder.complete()
                            .withTaskId(t.getId()).withVariable("content", contentToProcess).build());
                    }
                }


            }

        } else {
            LOGGER.info("> 我没有工作要做。");
        }

    }


    @Bean
    public Connector tagTextConnector() {
        return integrationContext -> {
            Content contentToTag = (Content) integrationContext.getInBoundVariables().get("content");
            contentToTag.getTags().add(" :) ");
            integrationContext.addOutBoundVariable("content",
                contentToTag);
            LOGGER.info("最终内容: " + contentToTag);
            return integrationContext;
        };
    }

    @Bean
    public Connector discardTextConnector() {
        return integrationContext -> {
            Content contentToDiscard = (Content) integrationContext.getInBoundVariables().get("content");
            contentToDiscard.getTags().add(" :( ");
            integrationContext.addOutBoundVariable("content",
                contentToDiscard);
            LOGGER.info("最终内容: " + contentToDiscard);
            return integrationContext;
        };
    }


    private Content pickRandomString() {
        String[] texts = {"hello from london", "Hi there from activiti!", "all good news over here.", "I've tweeted about activiti today.",
            "other boring projects.", "activiti cloud - Cloud Native Java BPM"};
        return new Content(texts[new Random().nextInt(texts.length)], false, null);
    }


}
