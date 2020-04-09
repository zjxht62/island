package com.zjx.island.biz.activiti.examples.model;

/**
 * 查询任务历史请求Model
 *
 * @author trevor.zhao
 * @date 2020/4/9
 */
public class TaskQueryReqModel {
    /**
     * 流程定义id
     */
    private String processId;
    /**
     * 是否已经完成
     */
    private boolean finished;

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "TaskQueryReqModel{" +
            "processId='" + processId + '\'' +
            ", finished=" + finished +
            '}';
    }
}
