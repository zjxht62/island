package com.zjx.island.biz.aop;

import org.apache.coyote.http11.filters.VoidInputFilter;
import org.aspectj.lang.annotation.*;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2019/10/17
 */
@Aspect
public class Audience {

    //定义命名的切点
    @Pointcut("execution(* com.zjx.island.biz.aop.Performance.perform(..))")
    public void performance() {}

    //表演之前
    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    //表演之前
    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    //表演之后
    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP! CLAP! CLAP!");
    }


    //表演失败之后
    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }


}
