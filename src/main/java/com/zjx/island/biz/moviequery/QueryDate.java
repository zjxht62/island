package com.zjx.island.biz.moviequery;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2020/11/19
 */
public class QueryDate {
    private int year;
    private int month;
    private int day;

    public QueryDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "QueryDate{" +
            "year='" + year + '\'' +
            ", month='" + month + '\'' +
            ", day='" + day + '\'' +
            '}';
    }

    public String getTargetDateString() {
        return month + "月" + day;
    }
}
