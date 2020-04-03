package com.zjx.island.biz.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

/**
 * 建立activiti数据表 但是有问题参考:https://www.jianshu.com/p/48bf76856051
 *
 * @author trevor.zhao
 * @date 2020/3/20
 */
public class TestActivitiTable {
    /** 使用代码创建工作流所需的25张表 **/
    @Test
    public void test() {
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration
            .createStandaloneProcessEngineConfiguration();
        // 链接数据库的配置
        configuration.setJdbcDriver("com.mysql.jdbc.Driver");
        configuration.setJdbcUrl("jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
        configuration.setJdbcUsername("root");
        configuration.setJdbcPassword("c9r6e2h7");
//        configuration.setDatabaseSchema("ACT");
        /*
         * DB_SCHEMA_UPDATE_FALSE 不能创建表，需要表存在
         * DB_SCHEMA_UPDATE_CREATE_DROP 先删除表再创建表
         * DB_SCHEMA_UPDATE_TRUE 如表不存在自动创建表
         */
        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_CREATE_DROP);
        //工作流的核心对象，ProcessEngine对象
        ProcessEngine processEngine= configuration.buildProcessEngine();
        System.out.println("processEngine="+processEngine);
    }
}
