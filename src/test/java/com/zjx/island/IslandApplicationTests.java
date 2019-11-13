package com.zjx.island;

import com.zjx.island.biz.di.BraveKnight;
import com.zjx.island.biz.di.Knight;
import com.zjx.island.biz.di.KnightConfig;
import com.zjx.island.biz.di.SlayDragonQuest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.swing.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IslandApplicationTests {

    @Test
    public void contextLoads() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(KnightConfig.class);
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();

    }

}

