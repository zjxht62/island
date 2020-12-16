package com.zjx.island.biz.junitdemo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Junit参数化测试demo
 *
 * @author trevor.zhao
 * @date 2020/12/16
 */
@RunWith(Parameterized.class)
public class PrimeNumberCheckerTest {
    private Integer inputNumber;
    private Boolean expectedResult;
    private PrimeNumberChecker primeNumberChecker;

    @Before
    public void initialize() {
        primeNumberChecker = new PrimeNumberChecker();
    }

    //每个参数都应该在这里作为一个参数,它将传递我们在primeNumbers()里定义的参数
    public PrimeNumberCheckerTest(Integer inputNumber, Boolean expectedResult) {
        this.inputNumber = inputNumber;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][] {
            { 2, true },
            { 6, false },
            { 19, true },
            { 22, false },
            { 23, true }
        });
    }


    // This test will run 4 times since we have 5 parameters defined
    @Test
    public void testPrimeNumberChecker() {
        System.out.println("Parameterized Number is : " + inputNumber);
        assertEquals(expectedResult,
            primeNumberChecker.validate(inputNumber));
    }
}
