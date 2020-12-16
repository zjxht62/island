package com.zjx.island.biz.junitdemo;

import org.junit.Before;
import org.junit.BeforeClass;

/**
 * 测试Junit注解在类继承关系中的执行
 *
 * @author trevor.zhao
 * @date 2020/12/15
 */
public class JunitAnnotationBase {

    @BeforeClass
    public static void beforeClassBase() {
        System.out.println("父类的BeforeClass");
    }

    @Before
    public void beforeBase() {
        System.out.println("父类的Before");
    }

}
