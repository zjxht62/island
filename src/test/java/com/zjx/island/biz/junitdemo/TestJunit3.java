package com.zjx.island.biz.junitdemo;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestResult;
import org.apache.coyote.http11.filters.VoidInputFilter;

/**
 * TestResult类demo
 */
public class TestJunit3 extends TestResult {
    public synchronized void addError(Test test, Throwable t) {
        super.addError((junit.framework.Test)test, t);
    }

    // add the failure
    public synchronized void addFailure(Test test, AssertionFailedError t) {
        super.addFailure((junit.framework.Test) test, t);
    }

    @org.junit.Test
    public void testAdd() {
        // add any test
    }

    // Marks that the test run should stop.
    public synchronized void stop() {
        //stop the test here
    }
}
