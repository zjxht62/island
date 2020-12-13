package com.zjx.island.biz.helper.kingdom;

import com.zjx.island.biz.helper.HtmlDataHandler;
import com.zjx.island.biz.helper.PneumoniaBoard.PneumoniaData;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.zjx.island.utils.HTMLUtil.getDocument;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2020/1/22
 */
public class ResourceHtmlHandler implements HtmlDataHandler {
    @Override
    public Map<String, ResourceInfoModel> handleData(String data) {
        Map<String, ResourceInfoModel> resultMap = new HashMap<>();
        Document document = getDocument(data);
        //选取所有第二季的div
        Elements allStatus = document.select("#full-width > div > div:nth-child(11) > div:nth-child(8) > div");
        for (Element element : allStatus) {
            String[] htmlStringArray = element.text().split(" ");
            String name = htmlStringArray[0];
            if (element.getElementsByTag("a").size()>0) {
                Boolean isDownloadable = true;
                String baiduUrl = element.getElementsByTag("a").get(1).attr("href");
                String extractionCode = "";
                if (7 == htmlStringArray.length) {
                    extractionCode = htmlStringArray[6];
                }
                ResourceInfoModel resourceInfoModel = new ResourceInfoModel(isDownloadable, name, baiduUrl, extractionCode);
                resultMap.put(name, resourceInfoModel);
            } else {
                ResourceInfoModel resourceInfoModel = new ResourceInfoModel(false, name, "", "");
                resultMap.put(name, resourceInfoModel);
            }
        }
        System.out.println(resultMap);
        return resultMap;
    }


}
