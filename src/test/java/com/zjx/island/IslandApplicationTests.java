package com.zjx.island;

import com.zjx.island.biz.di.BraveKnight;
import com.zjx.island.biz.di.Knight;
import com.zjx.island.biz.di.KnightConfig;
import com.zjx.island.biz.di.SlayDragonQuest;
import com.zjx.island.biz.helper.BusQueryModel;
import com.zjx.island.controller.helper.LittleHelperController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.swing.*;
import java.awt.geom.QuadCurve2D;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IslandApplicationTests {

    @Autowired
    LittleHelperController littleHelperController;

    @Test
    public void contextLoads() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(KnightConfig.class);
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();

    }

    @Test
    public void testHelper() throws Exception{
//        littleHelperController.getLineDirOptionByLine("105");
        BusQueryModel queryModel = new BusQueryModel();
        queryModel.setLine("105");
        queryModel.setDirName("105(白石桥东-天桥)");
        queryModel.setStationName("宣武门内");
//        littleHelperController.getStationOptionByDir(queryModel);

        littleHelperController.getDistanceByStation(queryModel);
    }

}

