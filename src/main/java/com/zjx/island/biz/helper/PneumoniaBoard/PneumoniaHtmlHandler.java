package com.zjx.island.biz.helper.PneumoniaBoard;

import com.zjx.island.biz.helper.HtmlDataHandler;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import static com.zjx.island.utils.HTMLUtil.getDocument;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2020/1/22
 */
public class PneumoniaHtmlHandler implements HtmlDataHandler {
    @Override
    public PneumoniaData handleData(String data) {
        PneumoniaData pneumoniaData = new PneumoniaData();
        Document document = getDocument(data);
        Element allStatus = document.selectFirst("p.confirmedNumber___3WrF5");
        Element beijingNums = document.select("p.descList___3iOuI").get(4);
        Element untilTime = document.selectFirst("p.mapTitle___2QtRg");
        pneumoniaData.setAllStatus(allStatus.text());
        pneumoniaData.setBeijingNums(beijingNums.text());
        pneumoniaData.setUntilTime(untilTime.text());

        return pneumoniaData;
    }
}
