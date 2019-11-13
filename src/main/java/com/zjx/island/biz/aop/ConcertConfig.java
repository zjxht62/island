package com.zjx.island.biz.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2019/10/17
 */
@Configuration
@EnableAspectJAutoProxy //启用AspectJ自动代理
@ComponentScan
public class ConcertConfig {
    /**
     * 创建AudienceBean
     * @return Audience实例
     */
    @Bean
    public Audience audience() {
        return new Audience();
    }
}
