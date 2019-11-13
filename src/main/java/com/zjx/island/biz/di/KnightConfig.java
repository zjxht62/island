package com.zjx.island.biz.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * java方式配置bean装配
 *
 * @author trevor.zhao
 * @date 2019/10/14
 */
@Configuration
public class KnightConfig {

    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }
}
