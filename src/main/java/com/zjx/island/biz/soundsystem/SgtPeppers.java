package com.zjx.island.biz.soundsystem;

import org.springframework.stereotype.Component;

/**
 * 用注解的方式创建可发现的bean
 * @author trevor.zhao
 * @date 2019/10/15
 */
//@Component注解表明该类会作为组件类 告知spring为这个类创建Bean
@Component
//默认bean的id为类名第一个字母变小写 也就是sgtPeppers 可以通过下面形式指定bean的id
//@Component("lonelyHeartsClub")
public class SgtPeppers implements CompactDisc {
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
