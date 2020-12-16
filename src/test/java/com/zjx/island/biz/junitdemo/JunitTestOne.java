package com.zjx.island.biz.junitdemo;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * 测试类1
 *
 * @author trevor.zhao
 * @date 2020/12/15
 */
public class JunitTestOne {
    @Test
    public void test() {
        System.out.println("测试1");
        assertTrue(true);
    }
}
