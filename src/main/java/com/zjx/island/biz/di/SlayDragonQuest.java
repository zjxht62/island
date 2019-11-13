package com.zjx.island.biz.di;

import java.io.PrintStream;

/**
 * 杀恶龙任务 实现quest接口
 *
 * @author trevor.zhao
 * @date 2019/10/14
 */
public class SlayDragonQuest implements Quest {
    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public void embark() {
        stream.println("Embarking on quest to slay the dragon!");
    }
}
