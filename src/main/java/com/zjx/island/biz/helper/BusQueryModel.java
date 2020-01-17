package com.zjx.island.biz.helper;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2019/12/22
 */
public class BusQueryModel {
    String line;
    String dirName;
    String stationName;

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @Override
    public String toString() {
        return "BusQueryModel{" +
            "line='" + line + '\'' +
            ", dirName='" + dirName + '\'' +
            ", stationName='" + stationName + '\'' +
            '}';
    }
}
