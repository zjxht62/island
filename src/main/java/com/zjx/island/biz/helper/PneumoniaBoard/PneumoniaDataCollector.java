package com.zjx.island.biz.helper.PneumoniaBoard;


import com.zjx.island.utils.HTMLUtil;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2020/1/22
 */
public class PneumoniaDataCollector {
    private DataHandler handler;
    public static final String URL = "https://3g.dxy.cn/newh5/view/pneumonia";

    public String collectHtmlData() {
        return HTMLUtil.getSource(URL);
    }

    public PneumoniaData getResult() {
        handler = new PneumoniaHandler();
        return (PneumoniaData) handler.handleData(collectHtmlData());
    }

    public static void main(String[] args) {
        PneumoniaDataCollector collector = new PneumoniaDataCollector();
        String result = collector.getResult().toString();
        System.out.println(result);
    }
}
