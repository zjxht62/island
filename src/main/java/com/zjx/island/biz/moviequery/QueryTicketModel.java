package com.zjx.island.biz.moviequery;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2019/3/13
 */
public class QueryTicketModel {
    /**
     * 电影名称
     */
    private String movieName;

    /**
     * 电影Id
     */
    private String movieId;
    /**
     * 电影院列表
     */
    private List<Cinema> cinemaModelList;

    /**
     * 观影日期
     */
    private Date movieDate;


    public QueryTicketModel() {

    }

    public QueryTicketModel(String movieName, String movieId, List<Cinema> cinemaModelList, Date movieDate) {
        this.movieName = movieName;
        this.movieId = movieId;
        this.cinemaModelList = cinemaModelList;
        this.movieDate = movieDate;
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

    public List<Cinema> getCinemaModelList() {
        return cinemaModelList;
    }

    public void setCinemaModelList(List<Cinema> cinemaModelList) {
        this.cinemaModelList = cinemaModelList;
    }

    public Date getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(Date movieDate) {
        this.movieDate = movieDate;
    }

    @Override
    public String toString() {
        return "QueryTicketModel{" +
            "movieName='" + movieName + '\'' +
            ", movieId='" + movieId + '\'' +
            ", cinemaModelList=" + cinemaModelList +
            ", movieDate=" + movieDate +
            '}';
    }

    public static void main(String[] args) {
        Date date = new Date(2019, 2, 15);
        SimpleDateFormat ft = new SimpleDateFormat ("M月dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 3, 1);
        date = calendar.getTime();
        System.out.println("当前时间为: " + ft.format(date));

    }
}
