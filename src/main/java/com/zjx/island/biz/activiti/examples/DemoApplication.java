//package com.zjx.island.biz.activiti.examples;
//
//import org.activiti.api.model.shared.model.VariableInstance;
//import org.activiti.api.process.model.ProcessDefinition;
//import org.activiti.api.process.model.ProcessInstance;
//import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
//import org.activiti.api.process.runtime.ProcessRuntime;
//import org.activiti.api.process.runtime.connector.Connector;
//import org.activiti.api.runtime.shared.query.Page;
//import org.activiti.api.runtime.shared.query.Pageable;
//import org.activiti.api.task.model.Task;
//import org.activiti.api.task.model.builders.TaskPayloadBuilder;
//import org.activiti.api.task.runtime.TaskRuntime;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.Random;
//
//@SpringBootApplication
//@EnableScheduling
//public class DemoApplication implements CommandLineRunner {
//
//    private Logger logger = LoggerFactory.getLogger(DemoApplication.class);
//
//    private final ProcessRuntime processRuntime;
//
//    private final TaskRuntime taskRuntime;
//
//    private final SecurityUtil securityUtil;
//
//    public DemoApplication(ProcessRuntime processRuntime,
//                           TaskRuntime taskRuntime,
//                           SecurityUtil securityUtil) {
//        this.processRuntime = processRuntime;
//        this.taskRuntime = taskRuntime;
//        this.securityUtil = securityUtil;
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
//
//    }
//
//    @Override
//    public void run(String... args) {
//        securityUtil.logInAs("system");
//
//        Page<ProcessDefinition> processDefinitionPage = processRuntime.processDefinitions(Pageable.of(0, 10));
//        logger.info("> 可获得的流程定义有: " + processDefinitionPage.getTotalItems());
//        for (ProcessDefinition pd : processDefinitionPage.getContent()) {
//            logger.info("\t > 流程定义: " + pd);
//        }
//
//    }
//
//    @Scheduled(initialDelay = 1000, fixedDelay = 5000)
//    public void processText() {
//
//        securityUtil.logInAs("system");
//
//        Content content = pickRandomString();
//
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
//
//        logger.info("> 开始处理内容的过程: " + content + " at " + formatter.format(new Date()));
//
//        ProcessInstance processInstance = processRuntime.start(ProcessPayloadBuilder
//                .start()
//                .withProcessDefinitionKey("categorizeHumanProcess")
//                .withName("Processing Content: " + content)
//                .withVariable("content", content)
//                .build());
//        logger.info(">>> 创建流程实例: " + processInstance);
//
//
//    }
//
//    @Scheduled(initialDelay = 1000, fixedDelay = 5000)
//    public void checkAndWorkOnTasksWhenAvailable() {
//        securityUtil.logInAs("salaboy");
//
//        Page<Task> tasks = taskRuntime.tasks(Pageable.of(0, 10));
//        if (tasks.getTotalItems() > 0) {
//            for (Task t : tasks.getContent()) {
//
//                logger.info("> 领取任务: " + t.getId());
//                taskRuntime.claim(TaskPayloadBuilder.claim().withTaskId(t.getId()).build());
//
//                List<VariableInstance> variables = taskRuntime.variables(TaskPayloadBuilder.variables().withTaskId(t.getId()).build());
//                VariableInstance variableInstance = variables.get(0);
//                if (variableInstance.getName().equals("content")) {
//                    Content contentToProcess = variableInstance.getValue();
//                    logger.info("> 任务中收到的要批准的内容: " + contentToProcess);
//
//                    if (contentToProcess.getBody().contains("activiti")) {
//                        logger.info("> 用户批准内容");
//                        contentToProcess.setApproved(true);
//                    } else {
//                        logger.info("> 用户丢弃内容");
//                        contentToProcess.setApproved(false);
//                    }
//                    taskRuntime.complete(TaskPayloadBuilder.complete()
//                            .withTaskId(t.getId()).withVariable("content", contentToProcess).build());
//                }
//
//
//            }
//
//        } else {
//            logger.info("> 我没有工作要做。");
//        }
//
//    }
//
//
//    @Bean
//    public Connector tagTextConnector() {
//        return integrationContext -> {
//            Content contentToTag = (Content) integrationContext.getInBoundVariables().get("content");
//            contentToTag.getTags().add(" :) ");
//            integrationContext.addOutBoundVariable("content",
//                    contentToTag);
//            logger.info("最终内容: " + contentToTag);
//            return integrationContext;
//        };
//    }
//
//    @Bean
//    public Connector discardTextConnector() {
//        return integrationContext -> {
//            Content contentToDiscard = (Content) integrationContext.getInBoundVariables().get("content");
//            contentToDiscard.getTags().add(" :( ");
//            integrationContext.addOutBoundVariable("content",
//                    contentToDiscard);
//            logger.info("最终内容: " + contentToDiscard);
//            return integrationContext;
//        };
//    }
//
//
//    private Content pickRandomString() {
//        String[] texts = {"hello from london", "Hi there from activiti!", "all good news over here.", "I've tweeted about activiti today.",
//                "other boring projects.", "activiti cloud - Cloud Native Java BPM"};
//        return new Content(texts[new Random().nextInt(texts.length)],false,null);
//    }
//
//}
