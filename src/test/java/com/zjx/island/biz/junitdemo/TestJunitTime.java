package com.zjx.island.biz.junitdemo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Junit时间测试
 *
 * @author trevor.zhao
 * @date 2020/12/15
 */
public class TestJunitTime {
    String message = "Robert";
    MessageUtil2 messageUtil2 = new MessageUtil2(message);

    @Test(timeout = 1000)
    public void testPrintMessage() {
        System.out.println("Inside testPrintMessage");
        messageUtil2.printMessage();
    }

    @Test
    public void testSalutationMessage() {
        System.out.println("Inside testSalutationMessage");
        message = "Hi!" + "Robert";
        Assert.assertEquals(message, messageUtil2.salutationMessage());
    }
}
