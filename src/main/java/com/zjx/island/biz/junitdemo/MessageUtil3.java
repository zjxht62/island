package com.zjx.island.biz.junitdemo;

/**
 * 用来测试junit 异常测试
 *
 * @author trevor.zhao
 * @date 2020/12/10
 */
public class MessageUtil3 {
    private String message;

    public MessageUtil3(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
        int a = 0;
        int b = 1/a;
    }

    public String salutationMessage() {
        message = "Hi!" + message;
        System.out.println(message);
        return message;
    }
}
