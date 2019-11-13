package com.zjx.island.biz.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2019/10/15
 */
@Configuration
//如果没有其他配置的话@ComponentScan会默认扫描与配置类相同的包.因为CDPlayerConfig类位于
//soundsystem包中,因此spring会扫描这个包以及包下的所有子包,查找带有@Component注解的类.这样就会发现CompactDisc,
//并且在spring中自动为其创建一个bean
@ComponentScan

//可用如下形式指定扫描基础包
//@ComponentScan(basePackages = "com.zjx.island.biz")
//@ComponentScan(basePackages = {"soundsystem", "video"})

//另外的形式可以指定为包中所包含的类或接口
//会扫描指定类所在的包作为基础包
//@ComponentScan(basePackageClasses = {CDPlayer.class, DVDPlayer.class})

public class CDPlayerConfig {
}
