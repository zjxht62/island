package com.zjx.island.biz.junitdemo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Junit异常测试
 *
 * @author trevor.zhao
 * @date 2020/12/15
 */
public class TestJunitException {
    String message = "Robert";
    MessageUtil3 messageUtil3 = new MessageUtil3(message);

    @Test(expected = ArithmeticException.class)
    public void testPrintMessage() {
        System.out.println("Inside testPrintMessage()");
        messageUtil3.printMessage();
    }

    @Test
    public void testSalutationMessage() {
        System.out.println("Inside testSalutation()");
        message = "Hi!" + "Robert";
        Assert.assertEquals(message, messageUtil3.salutationMessage());
    }
}
