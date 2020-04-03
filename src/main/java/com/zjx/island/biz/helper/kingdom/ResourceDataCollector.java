package com.zjx.island.biz.helper.kingdom;


import com.zjx.island.biz.helper.HtmlDataHandler;
import com.zjx.island.biz.helper.PneumoniaBoard.PneumoniaData;
import com.zjx.island.biz.helper.PneumoniaBoard.PneumoniaHtmlHandler;
import com.zjx.island.utils.HTMLUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Map;

import static com.zjx.island.utils.HTMLUtil.getDocument;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2020/1/22
 */
public class ResourceDataCollector {
    private HtmlDataHandler handler;
    public static final String URL = "http://www.zimuxia.cn/portfolio/%e8%a5%bf%e9%83%a8%e4%b8%96%e7%95%8c";

    public String collectHtmlData() {
        return HTMLUtil.getSource(URL);
    }

    public Map<String, ResourceInfoModel> getResult() {
        handler = new ResourceHtmlHandler();
        return (Map<String, ResourceInfoModel>) handler.handleData(collectHtmlData());
    }

    public static void main(String[] args) {
        ResourceDataCollector collector = new ResourceDataCollector();
        Document document = getDocument(collector.collectHtmlData());
        Element allStatus = document.selectFirst("#full-width > div > div:nth-child(11) > div:nth-child(3) > div:nth-child(4) > div:nth-child(3) > div:nth-child(5)");
        Elements links = allStatus.select("a");
        System.out.println(links.size());
        for (Element link : links) {
            System.out.println(link.attr("href"));
        }


    }
}
