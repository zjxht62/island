package com.zjx.island.biz.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试类
 *
 * @author trevor.zhao
 * @date 2019/10/14
 */
public class KnightMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(KnightConfig.class);
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }
}
