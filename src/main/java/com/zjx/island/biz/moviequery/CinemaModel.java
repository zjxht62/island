package com.zjx.island.biz.moviequery;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2019/3/13
 */
public class CinemaModel {
    /**
     * 电影院名称
     */
    private String cinemaName;
    /**
     * 电影院ID
     */
    private String cinemaId;

    public CinemaModel() {
    }

    public CinemaModel(String cinemaName, String cinemaId) {
        this.cinemaName = cinemaName;
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }

    @Override
    public String toString() {
        return "CinemaModel{" +
            "cinemaName='" + cinemaName + '\'' +
            ", cinemaId='" + cinemaId + '\'' +
            '}';
    }
}
