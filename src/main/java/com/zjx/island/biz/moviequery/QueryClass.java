package com.zjx.island.biz.moviequery;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjx.island.common.Constant;
import com.zjx.island.model.CinemaModel;
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
    List<CinemaModel> cinemaModelList;

    public QueryClass() {

    }

    public QueryClass(List<CinemaModel> cinemaModelList) {
        this.cinemaModelList = cinemaModelList;
    }

    public void initCinemaList(){
//        cinemaModelList = new ArrayList<>();
//        CinemaModel xidanCinema = new CinemaModel(Constant.CinemaIdConstants.XIDAN_ID, "西单首都电影院");
//        CinemaModel apmCinema = new CinemaModel(Constant.CinemaIdConstants.APM_ID, "王府井APM");
//        CinemaModel hengdianCinema = new CinemaModel(Constant.CinemaIdConstants.HENGDIAN_ID, "王府井横店");
//        cinemaModelList.add(xidanCinema);
//        cinemaModelList.add(apmCinema);
//        cinemaModelList.add(hengdianCinema);

    }

    public void queryMovies(QueryModel queryModel) {
        logger.info("查询Model信息:" + queryModel.toString());
        String queryDate = queryModel.getMonth() + "月" + queryModel.getDay();
        StringBuilder stringBuilder = new StringBuilder();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        for (int i = 0; i < cinemaModelList.size(); i++) {
            Document document = getDocument(getSource("https://maoyan.com/cinema/" + queryModel.getCinemaId() + "?poi=283722&movieId=" + queryModel.getMovieId()));
            Elements elements = document.select(".show-list");
            stringBuilder.append("ฅ՞•ﻌ•՞ฅ 任务执行~喵~\n" + "影院名称喵~\n" + "        " + queryModel.getCinemaName() + "\n" + "想看的电影喵~\n" + "        " + queryModel.getMovieName() + "\n日期喵~\n");
            for (Element element : elements) {
                if (element.select(".movie-name:contains(" + queryModel.getMovieName() + ")").toString().length() != 0) {
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
                try {
                    DingdingRobotUtil.testSendTextMessage(df.format(new Date()) + "\n" + stringBuilder.toString(), Constant.url.MOVIE_ROBOT_URL);
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                EmailUtil.send("trevor.zhao@trustlife.com",stringBuilder.toString() + "\n当前时间"
//                    + df.format(new Date()), false,"定时任务_查询_" + queryModel.getMovieName()+ "_排片_" + queryModel.getCinemaName());
            }
            stringBuilder.delete(0, stringBuilder.length());
//        }


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

    }

}
