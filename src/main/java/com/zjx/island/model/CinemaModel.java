package com.zjx.island.model;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2019/1/31
 */
public class CinemaModel {
    /**
     * 影院ID
     */
    String cinemaId;
    /**
     * 影院名
     */
    String cinemaName;

    public CinemaModel(String cinemaId, String cinemaName) {
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
    }

    public String getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    @Override
    public String toString() {
        return "CinemaModel{" +
            "cinemaId='" + cinemaId + '\'' +
            ", cinemaName='" + cinemaName + '\'' +
            '}';
    }
}
