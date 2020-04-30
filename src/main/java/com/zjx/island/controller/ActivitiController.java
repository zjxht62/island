package com.zjx.island.controller;

import com.alibaba.fastjson.JSON;
import com.zjx.island.biz.activiti.examples.CallRequest;
import com.zjx.island.biz.activiti.examples.Content;
import com.zjx.island.biz.activiti.examples.Headers;
import com.zjx.island.biz.activiti.examples.SecurityUtil;
import com.zjx.island.biz.activiti.examples.model.ProcessInstanceReqModel;
import com.zjx.island.biz.activiti.examples.model.TaskQueryReqModel;
import io.swagger.annotations.Api;
import io.swagger.models.HttpMethod;
import org.activiti.api.model.shared.model.VariableInstance;
import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.process.runtime.connector.Connector;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.Task;
import org.activiti.api.task.model.builders.ClaimTaskPayloadBuilder;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.model.payloads.CreateTaskVariablePayload;
import org.activiti.api.task.model.payloads.SaveTaskPayload;
import org.activiti.api.task.model.payloads.UpdateTaskPayload;
import org.activiti.api.task.runtime.TaskRuntime;
import org.activiti.engine.HistoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.apache.http.protocol.HTTP;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import javax.print.ServiceUI;
import java.lang.reflect.Method;
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

    @Autowired
    private HistoryService historyService;

    private static final String PROCESS_ID = "trustOperation";

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

    @RequestMapping(value = "/newProcessInstance", method = RequestMethod.POST)
    @ResponseBody
    public void processANewInstance(@RequestBody ProcessInstanceReqModel processInstanceReqModel) {
        securityUtil.logInAs("trevor");

        Headers headers = new Headers("contentType", "application/json");
        CallRequest callRequest = new CallRequest("www.trustlife.com", "{empty}", headers);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy HH:mm:ss");

        LOGGER.info("> 开始新建ProcessInstance,名为: " + processInstanceReqModel.getName() + " at " + formatter.format(new Date()));

        ProcessInstance processInstance = processRuntime.start(ProcessPayloadBuilder
            .start()
            .withProcessDefinitionKey(processInstanceReqModel.getProcessId())
            .withName(processInstanceReqModel.getName())
            .withBusinessKey(processInstanceReqModel.getName())
            .withVariable("approved", false)
            .withVariable("callRequest", callRequest)
            .build());
        LOGGER.info(">>> 创建流程实例: " + processInstance);
    }

    /**
     * 获取所有我可以执行的任务
     * @param userName
     * @return
     */
    @RequestMapping(value = "/getAllMyTasks/{userName}", method = RequestMethod.GET)
    @ResponseBody
    public String getAllMyTasks(@PathVariable("userName") String userName) {
        securityUtil.logInAs(userName);
        Page<Task> tasks = taskRuntime.tasks(Pageable.of(0, 10));
        if (tasks.getTotalItems() > 0) {
            return JSON.toJSONString(tasks.getContent());
        } else {
            return null;
        }
    }


    @RequestMapping(value = "/claimTaskById/{userName}/{taskId}", method = RequestMethod.GET)
    @ResponseBody
    public String claimTaskById(@PathVariable("userName") String userName, @PathVariable("taskId") String taskId) {
        securityUtil.logInAs(userName);
        taskRuntime.claim(TaskPayloadBuilder.claim().withTaskId(taskId).build());
        LOGGER.info("领取ID为:" + taskId + "的任务");
        return JSON.toJSONString(taskRuntime.task(taskId).toString());
    }

    @RequestMapping(value = "/releaseTaskById/{userName}/{taskId}", method = RequestMethod.GET)
    @ResponseBody
    public String releaseTaskById(@PathVariable("userName") String userName, @PathVariable("taskId") String taskId) {
        securityUtil.logInAs(userName);
        taskRuntime.release(TaskPayloadBuilder.release().withTaskId(taskId).build());
        LOGGER.info("释放ID为:" + taskId + "的任务");
        return JSON.toJSONString(taskRuntime.task(taskId).toString());
    }

    @RequestMapping(value = "/getTaskParams/{userName}/{taskId}", method = RequestMethod.GET)
    @ResponseBody
    public String getTaskParams(@PathVariable("userName") String userName, @PathVariable("taskId") String taskId) {
        securityUtil.logInAs(userName);
        CallRequest result = null;

        List<VariableInstance> variables = taskRuntime.variables(TaskPayloadBuilder.variables().withTaskId(taskId).build());
        Iterator<VariableInstance> iterator = variables.iterator();
        while (iterator.hasNext()) {
            VariableInstance variableInstance = iterator.next();
            LOGGER.info("> 所有的变量有: " + variableInstance.getName());
            if (variableInstance.getName().equals("initiator")) {
                LOGGER.info("> initiator初始化的人是:" + variableInstance.getValue());
            }
            else if (variableInstance.getName().equals("callRequest")) {
                result = variableInstance.getValue();
                LOGGER.info("> 任务中收到的要调用的接口信息: " + result);
                LOGGER.info("> 调用接口请求url：" + result.getUrl());
                LOGGER.info("> 调用接口请求body：" + result.getBody());
                LOGGER.info("> 请求头：" + result.getHeaders());
            }
        }

        return JSON.toJSONString(result);


    }

    @RequestMapping(value = "/completeTaskById/{userName}/{taskId}", method = RequestMethod.GET)
    @ResponseBody
    public String completeTaskById(@PathVariable("userName") String userName, @PathVariable("taskId") String taskId) {
        securityUtil.logInAs(userName);
//        taskRuntime.updateVariable(TaskPayloadBuilder.updateVariable().withTaskId(taskId).withVariable("approved", true).build());
        taskRuntime.complete(TaskPayloadBuilder.complete().withTaskId(taskId).withVariable("approved", true).build());
        LOGGER.info("完成ID为:" + taskId + "的任务");
        return "完成了任务";
    }



    @RequestMapping(value = "/checkAndWorkOnTasksWhenAvailable/{userName}", method = RequestMethod.GET)
    @ResponseBody
    public void checkAndWorkOnTasksWhenAvailable(@PathVariable("userName") String userName) {
//        securityUtil.logInAs("system");
        securityUtil.logInAs(userName);

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

    @RequestMapping(value = "/history", method = RequestMethod.POST)
    @ResponseBody
    public void getTaskHistory(@RequestBody TaskQueryReqModel taskQueryReqModel) {
        System.out.println("获取历史");
        HistoricTaskInstanceQuery historicTaskInstanceQuery = historyService.createHistoricTaskInstanceQuery();
        historicTaskInstanceQuery.processDefinitionKey(taskQueryReqModel.getProcessId());
        if (taskQueryReqModel.isFinished()) {
            historicTaskInstanceQuery.finished();
        } else {
            historicTaskInstanceQuery.unfinished();
        }
        List<HistoricTaskInstance> historicTaskInstanceList = historicTaskInstanceQuery.list();
        int count = 0;
        for (HistoricTaskInstance taskInstance : historicTaskInstanceList) {
            LOGGER.info("结果：" + count);
            LOGGER.info("pid:" + taskInstance.getId()+",");
            LOGGER.info("pdid:" + taskInstance.getProcessDefinitionId()+",");
            LOGGER.info("startTime:" + taskInstance.getStartTime()+",");
            LOGGER.info("endTime:" + taskInstance.getEndTime()+",");
            LOGGER.info("owner:" + taskInstance.getOwner()+",");
            LOGGER.info("assignee:" + taskInstance.getAssignee());
            LOGGER.info("vars:" + taskInstance.getProcessVariables());
            count++;
        }

    }





    @Bean
    public Connector myConnector() {
        return integrationContext -> {
            CallRequest callRequestToDiscard = (CallRequest) integrationContext.getInBoundVariables().get("callRequest");
            callRequestToDiscard.setBody("执行调用body的serviceTask");
            integrationContext.addOutBoundVariable("callRequest",
                callRequestToDiscard);
            LOGGER.info("调用接口: " + callRequestToDiscard);
            return integrationContext;
        };
    }


    private Content pickRandomString() {
        String[] texts = {"hello from london", "Hi there from activiti!", "all good news over here.", "I've tweeted about activiti today.",
            "other boring projects.", "activiti cloud - Cloud Native Java BPM"};
        return new Content(texts[new Random().nextInt(texts.length)], false, null);
    }


}
