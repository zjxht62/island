package com.zjx.island.biz.helper;

import java.util.HashMap;
import java.util.Map;

/**
 * 线路方向查询结果model
 *
 * @author trevor.zhao
 * @date 2020/1/17
 */
public class LineDirResultModel {
    /**
     * 返回给手机的方向结果
     */
    private String dirResult;
    /**
     * 存储线路方向和对应码值的map
     */
    private Map<String, String> dirMap = new HashMap<>();

    public String getDirResult() {
        return dirResult;
    }

    public void setDirResult(String dirResult) {
        this.dirResult = dirResult;
    }

    public Map<String, String> getDirMap() {
        return dirMap;
    }

    public void setDirMap(Map<String, String> dirMap) {
        this.dirMap = dirMap;
    }

    @Override
    public String toString() {
        return "LineDirResultModel{" +
            "dirResult='" + dirResult + '\'' +
            ", dirMap=" + dirMap +
            '}';
    }
}
