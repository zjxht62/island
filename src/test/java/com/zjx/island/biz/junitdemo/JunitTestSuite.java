package com.zjx.island.biz.junitdemo;

import junit.framework.TestResult;
import junit.framework.TestSuite;

/**
 * Junit测试套件
 */
public class JunitTestSuite {
    public static void main(String[] args) {
        TestSuite suite = new TestSuite(TestJunit3.class);
        TestResult testResult = new TestResult();
        suite.run(testResult);
        System.out.println("Number of test cases = " + testResult.runCount());
    }
}
