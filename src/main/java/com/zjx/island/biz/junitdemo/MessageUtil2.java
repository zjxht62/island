package com.zjx.island.biz.junitdemo;

/**
 * 用来测试junit 时间测试
 *
 * @author trevor.zhao
 * @date 2020/12/10
 */
public class MessageUtil2 {
    private String message;

    public MessageUtil2(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
        while (true);
    }

    public String salutationMessage() {
        message = "Hi!" + message;
        System.out.println(message);
        return message;
    }
}
