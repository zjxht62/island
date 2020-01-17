package com.zjx.island.biz.helper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjx.island.utils.HTMLUtil;
import com.zjx.island.utils.HttpUWUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2019/12/7
 */


@Component
public class BusHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(BusHelper.class);

    private BusQueryModel busQueryModel = new BusQueryModel();



    /**
     * 通过get请求拿到返回结果
     * @param line 线路名
     * @return 返回结果
     */
    public String doHttpRequestGetLineDirOption(String line) {
        String response = null;
        try {
            response = HttpUWUtil.doGetStr("http://www.bjbus.com/home/ajax_rtbus_data.php?act=getLineDirOption&selBLine=" + line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }


    /**
     * 处理线路方向返回结果
     * @param response
     * @return 结果model
     */
    public LineDirResultModel handleDirectionResult(String response) {
        LineDirResultModel lineDirResultModel = new LineDirResultModel();
        Map<String, String> dirMap = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        Document document = HTMLUtil.getDocument(response);
        Elements options = document.select("option");
        for (Element element : options) {
            if ("".equals(element.attr("value"))) {
                continue;
            }
            dirMap.put(element.html(), element.attr("value"));
            sb.append(element.html() + "\n");
        }

        lineDirResultModel.setDirMap(dirMap);
        lineDirResultModel.setDirResult(sb.toString());

        return lineDirResultModel;


    }

    /**
     * 根据线路名拿到返回给手机的内容
     * @param line
     * @return
     */
    public String getLineDirOptionToMobileByLine(String line) {
        return handleDirectionResult(doHttpRequestGetLineDirOption(line)).getDirResult();
    }

    /**
     *根据线路名拿到线路方向的map
     * @param line
     * @return
     */
    public Map<String, String> getLineDirOptionMapByLine(String line) {
        return handleDirectionResult(doHttpRequestGetLineDirOption(line)).getDirMap();

    }


    /**
     * http请求拿到站点信息
     * @param line 线路名
     * @param lineString 方向名
     * @return 接口返回结果
     */
    public String doHttpGetStationOptionByDir(String line, String lineString) {
        String dirCode = getLineDirOptionMapByLine(line).get(lineString);
        String response = null;
        try {
            response = HttpUWUtil.doGetStr("http://www.bjbus.com/home/ajax_rtbus_data.php?act=getDirStationOption&selBLine=" + line + "&selBDir=" + dirCode);
            LOGGER.info(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 处理站点返回结果
     * @param response
     * @return
     */
    public StationResultModel handleStationResult(String response) {
        StationResultModel stationResultModel = new StationResultModel();

        Map<String, String> stationMap = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        Document document = HTMLUtil.getDocument(response);
        Elements options = document.select("option");
        for (Element element : options) {
            if ("".equals(element.attr("value"))) {
                continue;
            }
            stationMap.put(element.html(), element.attr("value"));
            sb.append(element.html() + "\n");
        }

        stationResultModel.setStationMap(stationMap);
        stationResultModel.setStationResult(sb.toString());
        return stationResultModel;

    }



    /**
     * 根据方向拿到返回给手机的内容
     * @param line
     * @return
     */
    public String getStationOptionToMobileByLine(String line, String lineString) {
        return handleStationResult(doHttpGetStationOptionByDir(line, lineString)).getStationResult();
    }

    /**
     *根据方向名拿到线路站点的map
     * @param line
     * @return
     */
    public Map<String, String> getStationOptionMapByLine(String line, String lineString) {
        return handleStationResult(doHttpGetStationOptionByDir(line, lineString)).getStationMap();

    }




    public String getDistanceByStation(String line, String lineString, String station) {
        String dirCode = getLineDirOptionMapByLine(line).get(lineString);
        String stationCode = getStationOptionMapByLine(line, lineString).get(station);

        String result = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String response = HttpUWUtil.doGetStr("http://www.bjbus.com/home/ajax_rtbus_data.php?act=busTime&selBLine=" + line + "&selBDir=" + dirCode + "&selBStop=" + stationCode);
            JSONObject jsonObject = JSON.parseObject(response);
            String html = jsonObject.get("html").toString();
            Document document = HTMLUtil.getDocument(html);
            Element lh = document.select("#lh").get(0);
            Element article = document.selectFirst("article");
            Element p0 = article.selectFirst("p");
            Element p1 = article.select("p").get(1);
            stringBuilder.append(lh.text() + "\n" + p0.text() + "\n" + p1.text() + "\n");
            result = stringBuilder.toString();
            LOGGER.info(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}
