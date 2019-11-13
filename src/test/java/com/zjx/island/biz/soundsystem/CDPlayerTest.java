package com.zjx.island.biz.soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2019/10/15
 */
//自动创建spring的应用上下文
@RunWith(SpringJUnit4ClassRunner.class)
//告诉在那里加载配置
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    private MediaPlayer player;

    //注入到CDPlayerTest类
    @Autowired
    private CompactDisc cd;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
        cd.play();
    }

    @Test
    public void play() {
        player.play();
    }
}
