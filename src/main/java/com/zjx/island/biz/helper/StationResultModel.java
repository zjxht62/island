package com.zjx.island.biz.helper;

import java.util.HashMap;
import java.util.Map;

/**
 * 站点结果model
 *
 * @author trevor.zhao
 * @date 2020/1/17
 */
public class StationResultModel {
    /**
     * 返回给手机的站点结果
     */
    private String stationResult;
    /**
     * 存储站点和对应码值的map
     */
    private Map<String, String> stationMap = new HashMap<>();

    public String getStationResult() {
        return stationResult;
    }

    public void setStationResult(String stationResult) {
        this.stationResult = stationResult;
    }

    public Map<String, String> getStationMap() {
        return stationMap;
    }

    public void setStationMap(Map<String, String> stationMap) {
        this.stationMap = stationMap;
    }

    @Override
    public String toString() {
        return "StationResultModel{" +
            "stationResult='" + stationResult + '\'' +
            ", stationMap=" + stationMap +
            '}';
    }
}
