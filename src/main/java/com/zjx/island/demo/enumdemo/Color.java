package com.zjx.island.demo.enumdemo;

/**
 * 定义颜色枚举
 *
 * @author trevor.zhao
 * @date 2021/1/12
 */
public enum Color {
    RED(111),
    GREEN(222),
    BLUE(333);

    private int code;

    Color(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
