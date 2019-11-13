package com.zjx.island.biz.di;

/**
 * 实现了Knight接口的勇敢的Knight
 *
 * @author trevor.zhao
 * @date 2019/10/14
 */
public class BraveKnight implements Knight {
    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }
}
