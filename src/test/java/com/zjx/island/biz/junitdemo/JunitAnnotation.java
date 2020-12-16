package com.zjx.island.biz.junitdemo;

import org.junit.*;

/**
 * Junit注解测试
 *
 * @author trevor.zhao
 * @date 2020/12/15
 */

//@Ignore 如果作用到类上 则类中的所有测试都不会执行
public class JunitAnnotation extends JunitAnnotationBase{

    //测试类开始之前执行一次
    @BeforeClass
    public static void beforeClass() {
        System.out.println("BeforeClass");
    }

    //在测试类结束后执行
    @AfterClass
    public static void afterClass() {
        System.out.println("AfterClass");
    }

    //在每个测试方法前都执行一次
    @Before
    public void before() {
        System.out.println("Before");
    }

    //在每个测试方法后都执行一次
    @After
    public void after() {
        System.out.println("After");
    }

    //test case
    @Test
    public void test() {
        System.out.println("in test");
    }

    //test case1
    @Test
    public void test1() {
        System.out.println("in test1");
    }

    //test case ignore and will not execute
    @Ignore
    @Test
    public void ignoreTest() {
        System.out.println("Ignore");
    }



}
