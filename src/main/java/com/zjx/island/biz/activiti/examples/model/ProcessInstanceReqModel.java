package com.zjx.island.biz.activiti.examples.model;

/**
 * 新建流程实例的请求model
 *
 * @author trevor.zhao
 * @date 2020/4/9
 */
public class ProcessInstanceReqModel {
    /**
     * 要创建的流程ID
     */
    private String processId;
    /**
     * 创建的名称
     */
    private String name;

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProcessInstanceReqModel{" +
            "processId='" + processId + '\'' +
            ", name='" + name + '\'' +
            '}';
    }
}
