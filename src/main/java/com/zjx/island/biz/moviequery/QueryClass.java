package com.zjx.island.biz.moviequery;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjx.island.common.Constant;
import com.zjx.island.utils.DingdingRobotUtil;
import com.zjx.island.utils.HTMLUtil;
import com.zjx.island.utils.HttpUWUtil;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.zjx.island.utils.HTMLUtil.getDocument;
import static com.zjx.island.utils.HTMLUtil.getSource;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2019/1/31
 */
public class QueryClass {
    private static final Logger logger = Logger.getLogger(QueryClass.class);

    public QueryClass() {

    }

    /**
     * 根据传入的日期转换为查询中的字符串
     * @param movieDate date型观影日期
     * @return M月dd
     */
    public String getMovieDateString(Date movieDate) {
        SimpleDateFormat ft = new SimpleDateFormat ("M月dd");
        String dateString = ft.format(movieDate);
        if (dateString.charAt(2) == '0') {
            dateString = dateString.substring(0, 2) + dateString.substring(3, 4);
        }
        return dateString;
    }


    public void queryOneMovie(QueryTicketModel queryTicketModel) {
        logger.info("查询Model信息:" + queryTicketModel.toString());
        String queryDate = getMovieDateString(queryTicketModel.getMovieDate());
        logger.info("转换之后的日期:" + queryDate);
        StringBuilder stringBuilder = new StringBuilder();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        for (CinemaModel cinemaModel : queryTicketModel.getCinemaModelList()) {
            Document document = getDocument(getSource("https://maoyan.com/cinema/" + cinemaModel.getCinemaId() + "?poi=283722&movieId=" + queryTicketModel.getMovieId()));
            Elements elements = document.select(".show-list");
            stringBuilder.append("ฅ՞•ﻌ•՞ฅ 任务执行~喵~\n" + "影院名称喵~\n" + "        " + cinemaModel.getCinemaName() + "\n" + "想看的电影喵~\n" + "        " + queryTicketModel.getMovieName() + "\n日期喵~\n");
            for (Element element : elements) {
                if (element.select(".movie-name:contains(" + queryTicketModel.getMovieName() + ")").toString().length() != 0) {
                    for (int j = 0; j < element.select(".date-item").size(); j++) {
                        String day = element.select(".date-item").get(j).html();
//                        System.out.println(day);
                        if (day.contains(queryDate)) {
                            logger.info("指定日期出现排片");
                            stringBuilder.append("        " + day + "日" + "\n" + "放映时间喵~\n");
                        } else {
                            continue;
                        }
                        Elements beginTimes = element.select("tbody").get(j).select(".begin-time");
                        Elements endTimes = element.select("tbody").get(j).select(".end-time");
                        for (int i = 0; i < beginTimes.size(); i++) {
                            stringBuilder.append("        开场" + beginTimes.get(i).html() + "~" + endTimes.get(i).html() + "\n");
                        }
                    }
                }
            }

            if (stringBuilder.toString().contains(queryDate)) {
                logger.info("发钉钉信息\n" + stringBuilder.toString());
                sendNotification(df.format(new Date()) + "\n" + stringBuilder.toString(), Constant.url.MOVIE_ROBOT_URL);
            }
            stringBuilder.delete(0, stringBuilder.length());
        }


    }

    public void sendNotification(String message, String robotUrl) {
        try {
            DingdingRobotUtil.testSendTextMessage(message, robotUrl);
        } catch (Exception e) {
            logger.error("发送钉钉消息出现异常");
            e.printStackTrace();
        }

    }

    public void queryBus(List<String> getURLs) {
        String getResult = null;
        StringBuilder stringBuilder = new StringBuilder();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        try {
            for (int i = 0; i < getURLs.size(); i++) {
                getResult = HttpUWUtil.doGetStr(getURLs.get(i));
                JSONObject jsonObject = JSON.parseObject(getResult);
                String html = jsonObject.get("html").toString();
                Document document = HTMLUtil.getDocument(html);
                Element lh = document.select("#lh").get(0);
                Element article = document.selectFirst("article");
                Element p0 = article.selectFirst("p");
                Element p1 = article.select("p").get(1);
                stringBuilder.append(lh.text() + "\n" + p0.text() + "\n" + p1.text() + "\n");

            }

                logger.info("发钉钉信息\n" + stringBuilder.toString());
                try {
                    DingdingRobotUtil.testSendTextMessage(stringBuilder.toString(), Constant.url.BUS_ROBOT_URL);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            stringBuilder.delete(0, stringBuilder.length());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Date date = new Date(2020, 2, 10);
        QueryClass queryClass = new QueryClass();
        System.out.println(queryClass.getMovieDateString(date));


    }

//    public Document getDocument(String url) {
//        Document document = getDocument(getSource("https://maoyan.com/cinema/" + queryModel.getCinemaId() + "?poi=283722&movieId=" + queryModel.getMovieId()));
//
//    }


}
