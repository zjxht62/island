package com.zjx.island.biz.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2019/10/17
 */
@Aspect
public class Audience2 {

    //定义命名的切点
    @Pointcut("execution(* com.zjx.island.biz.aop.Performance.perform(..))")
    public void performance() {}


    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp) {
        try {
            System.out.println("Silencing cell phones");
            System.out.println("Taking Seats");
            //控制权交给被通知的方法
            jp.proceed();
            System.out.println("CLAP! CLAP! CLAP!");
        } catch (Throwable e) {
            System.out.println("Demanding a refund");
        }
    }




}
