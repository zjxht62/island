package com.zjx.island.biz.junitdemo;

import org.junit.Assert;
import org.junit.Test;

/**
 * 测试assert
 *
 * @author trevor.zhao
 * @date 2020/12/11
 */
public class TestJunit1 {

    @Test
    public void testAdd() {
        int num = 5;
        String temp = null;
        String str = "Junit is working fine";

        //测试equals
        Assert.assertEquals("Junit is working fine", str);

        //测试assertFalse
        Assert.assertFalse(num < 5);

        //测试not null
        Assert.assertNotNull(str);
    }
}
