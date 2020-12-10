package com.zjx.island.biz.junitdemo;

/**
 * 用来测试junit的测试类
 *
 * @author trevor.zhao
 * @date 2020/12/10
 */
public class MessageUtil {
    private String message;

    public MessageUtil(String message) {
        this.message = message;
    }

    public String printMessage() {
        System.out.println(message);
        return message;
    }
}
