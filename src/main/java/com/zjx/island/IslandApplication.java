package com.zjx.island;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IslandApplication {

    public static void main(String[] args) {
        SpringApplication.run(IslandApplication.class, args);
    }

}

