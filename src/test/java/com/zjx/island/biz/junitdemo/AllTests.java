package com.zjx.island.biz.junitdemo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 测试套件类
 *
 * @author trevor.zhao
 * @date 2020/12/15
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({JunitTestOne.class, JunitTestTwo.class})
public class AllTests {
}
