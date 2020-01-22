package com.zjx.island.biz.helper.PneumoniaBoard;

import java.util.Observable;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2020/1/22
 */
public class PneumoniaData extends Observable {
    /**
     * 截止时间
     */
    private String untilTime;
    /**
     * 总览状态
     */
    private String allStatus;
    /**
     * 北京病例
     */
    private String beijingNums;


    public PneumoniaData() {
    }

    public void dataChanged() {
        setChanged();
        notifyObservers();

    }

    public void setData(String untilTime, String allStatus, String beijingNums) {
        this.allStatus = allStatus;
        this.untilTime = untilTime;
        this.beijingNums = beijingNums;
        dataChanged();
    }

    public String getUntilTime() {
        return untilTime;
    }

    public void setUntilTime(String untilTime) {
        this.untilTime = untilTime;
    }

    public String getAllStatus() {
        return allStatus;
    }

    public void setAllStatus(String allStatus) {
        this.allStatus = allStatus;
    }

    public String getBeijingNums() {
        return beijingNums;
    }

    public void setBeijingNums(String beijingNums) {
        this.beijingNums = beijingNums;
    }

    @Override
    public String toString() {
        return "PneumoniaData{" +
            "untilTime='" + untilTime + '\'' +
            ", allStatus='" + allStatus + '\'' +
            ", beijingNums='" + beijingNums + '\'' +
            '}';
    }
}
