package com.zjx.island.biz.helper.kingdom;


import com.zjx.island.biz.helper.HtmlDataHandler;
import com.zjx.island.biz.helper.PneumoniaBoard.PneumoniaData;
import com.zjx.island.biz.helper.PneumoniaBoard.PneumoniaHtmlHandler;
import com.zjx.island.utils.HTMLUtil;

import java.util.Map;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2020/1/22
 */
public class ResourceDataCollector {
    private HtmlDataHandler handler;
    public static final String URL = "http://www.zimuxia.cn/portfolio/%e7%8e%8b%e5%9b%bd";

    public String collectHtmlData() {
        return HTMLUtil.getSource(URL);
    }

    public Map<String, ResourceInfoModel> getResult() {
        handler = new ResourceHtmlHandler();
        return (Map<String, ResourceInfoModel>) handler.handleData(collectHtmlData());
    }

    public static void main(String[] args) {
        ResourceDataCollector collector = new ResourceDataCollector();
        System.out.println(collector.getResult());
    }
}
