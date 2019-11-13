package com.zjx.island.biz.moviequery;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2019/3/13
 */
public class QueryModel {
    private String movieName;
    private String movieId;
    private String cinemaName;
    private String cinemaId;
    private Integer month;
    private Integer day;

    public QueryModel() {

    }

    public QueryModel(String movieName, String movieId, String cinemaName, String cinemaId, Integer month, Integer day) {
        this.movieName = movieName;
        this.movieId = movieId;
        this.cinemaName = cinemaName;
        this.cinemaId = cinemaId;
        this.month = month;
        this.day = day;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
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

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "QueryModel{" +
            "movieName='" + movieName + '\'' +
            ", movieId='" + movieId + '\'' +
            ", cinemaName='" + cinemaName + '\'' +
            ", cinemaId='" + cinemaId + '\'' +
            ", month=" + month +
            ", day=" + day +
            '}';
    }

    public static void main(String[] args) {
        Date date = new Date(2019, 2, 15);
        SimpleDateFormat ft = new SimpleDateFormat ("M月dd");

        System.out.println("当前时间为: " + ft.format(date));

    }
}
