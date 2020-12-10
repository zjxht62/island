package com.zjx.island.biz.junitdemo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2020/12/10
 */
public class TestMessageUtil {
    //初始化可以不放在测试方法里面，测试方法里面应该是真正被测试的内容
    String message = "a message";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testPrintMessage() {
        Assert.assertEquals(message, messageUtil.printMessage());
    }
}
