package com.zjx.island.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2019/10/12
 */
public class EmojiUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmojiUtil.class);

    private static List<String> emojiList = new ArrayList<String>() {
        {
            add("(っ´ω`c)");
            add("ヾ(*´∀ ˋ*)ﾉ");
            add("(・ω・)");
            add("(*´∀`)~♥");
            add("(〃∀〃)");
            add("(灬ºωº灬)");
            add("٩(｡・ω・｡)\uFEFFو");
            add("٩(๑•̀ω•́๑)۶");
            add("(๑• . •๑)");
            add("ヾ(●゜▽゜●)♡ ");
        }
    };


    public static String getRandomEmoji() {
        LOGGER.info("emojiList的size" + emojiList.size());
        int randomInt = (int) (Math.random() * emojiList.size());
        return "早啊" + emojiList.get(randomInt);

    }
}
