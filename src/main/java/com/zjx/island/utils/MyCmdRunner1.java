package com.zjx.island.utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * 自定义CmdRunner 学习一下
 *
 * @author trevor.zhao
 * @date 2020/3/20
 */
@Component
@Order(value = 1)
public class MyCmdRunner1 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>>测试一下CommandLineRunnerr order=1");

    }
}

