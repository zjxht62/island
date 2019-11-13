package com.zjx.island.biz.di;

import java.io.PrintStream;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2019/10/15
 */
public class Minstrel {
    private PrintStream stream;

    public Minstrel(PrintStream stream) {
        this.stream = stream;
    }
    //探险前调用
    public void singBeforeQuest() {
        stream.println("Fa la la, the knight is so brave");
    }

    //探险后调用
    public void singAfterQuest() {
        stream.println("Tee hee hee, the brave knight " +
            "did embark on a quest!");
    }
}
