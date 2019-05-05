package com.zjx.island.biz;

import com.zjx.island.biz.auto.MyTest;
import com.zjx.island.biz.query.QueryClass;
import com.zjx.island.biz.query.QueryModel;
import com.zjx.island.misc.Constant;
import com.zjx.island.model.OrderModel;
import com.zjx.island.model.PersonModel;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.zjx.island.utils.HTMLUtil.*;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2019/1/17
 */
@Component
public class Jobs {
    public static final long ONE_MINUTE = 60 * 1000;
    public static Boolean hasOrdered = false;
    private static final Logger logger = Logger.getLogger(Jobs.class);


//    @Scheduled(fixedDelay = 1000)
    public void fixedDelayJob() {
        PersonModel personzjx = new PersonModel("赵吉祥", "110107199409080613", "13241336315");
//        PersonModel personzjx2 = new PersonModel("赵吉祥", "110107199409080613", "13241336315");
        PersonModel personckx = new PersonModel("程可欣", "11010219940901194X", "13269417087");
        List<PersonModel> personModels = new ArrayList<>();
        personModels.add(personzjx);
        personModels.add(personckx);
//        personModels.add(personckx);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Document document = getDocument(getSource("http://xiaosongisland.com/yuyue.html"));
        List<String> aviliables = getAviliableTime(document);
        System.out.println(aviliables);
        OrderModel orderModel = hasAviliableTime(aviliables);
        System.out.println(orderModel + df.format(new Date()));
        //调试时放开下一行 设置为true
//        orderModel.setAviliable(true);
        if (orderModel.getAviliable() && hasOrdered == false) {
            for (int i = 0; i <personModels.size(); i++) {
                MyTest.deal(personModels.get(i));
            }
            hasOrdered = true;
//            EmailUtil.send("trevor.zhao@trustlife.com", orderModel.getAviliableString() + "当前时间" + df.format(new Date()), false,"晓岛目前可以预约啦");
        }
    }


//    @Scheduled(cron = "0 5 9,11,13,15,17,19,21,23 * * ?")
    @Scheduled(fixedDelay = 30 * ONE_MINUTE)
    public void xidanMovieJob() {
        logger.info("开始执行查询");
        QueryModel queryModel0 = new QueryModel("大侦探皮卡丘", "346629",
            Constant.CinemaConstants.CinemaName.XINHUADAZHONGSI, Constant.CinemaConstants.CinemaId.XINHUADAZHONGSI, 5, 10);
        QueryModel queryModel1 = new QueryModel("我的英雄学院", "1220571",
            Constant.CinemaConstants.CinemaName.DONGFANGGUANGCHANG, Constant.CinemaConstants.CinemaId.DONGFANGGUANGCHANG, 3, 17);
        QueryModel queryModel2 = new QueryModel("我的英雄学院", "1220571",
            Constant.CinemaConstants.CinemaName.XIDAN, Constant.CinemaConstants.CinemaId.XIDAN, 3, 17);
        QueryModel queryModel3 = new QueryModel("我的英雄学院", "1220571",
            Constant.CinemaConstants.CinemaName.WANGFUJING_APM, Constant.CinemaConstants.CinemaId.WANGFUJING_APM, 3, 17);
        QueryModel queryModel4 = new QueryModel("我的英雄学院", "1220571",
            Constant.CinemaConstants.CinemaName.SHIJINGSHANWANDA, Constant.CinemaConstants.CinemaId.SHIJINGSHANWANDA, 3, 17);

        QueryClass queryClass = new QueryClass();
        queryClass.queryMovies(queryModel0);
//        queryClass.queryMovies(queryModel1);
//        queryClass.queryMovies(queryModel2);
//        queryClass.queryMovies(queryModel3);
//        queryClass.queryMovies(queryModel4);
    }

//        StringBuilder stringBuilder = new StringBuilder();
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        Document document = getDocument(getSource("https://maoyan.com/cinema/149?poi=283722&movieId=457445"));
//        Elements elements = document.select(".show-list");
//        stringBuilder.append("掠食城市排片:\n");
//        for (Element element : elements) {
//            if (element.select(".movie-name:contains(掠食城市)").toString().length() != 0) {
//                for (int i = 0; i < element.select(".date-item").size(); i++) {
//                    String day = element.select(".date-item").get(i).html();
//                    if (day.contains("19")) {
//                        stringBuilder.append(day + "\n" + "  放映时间\n");
//                    } else {
//                        continue;
//                    }
//                    Elements times = element.select("tbody").get(i).select(".begin-time");
//                    for (Element time : times) {
//                        stringBuilder.append("    " + time.html() + "\n");
//                    }
//
//                }
//
//            }
//        }
//        System.out.println(stringBuilder.toString());
//        if (stringBuilder.toString().contains("月19")) {
//            EmailUtil.send("trevor.zhao@trustlife.com",stringBuilder.toString() + "\n当前时间" + df.format(new Date()), false,"定时任务--查询排片--西单");
//        }
//        stringBuilder.delete(0, stringBuilder.length());
//    }


    public static void main(String[] args) {
        try {
//            DingdingRobotUtil.testSendTextMessage();
        } catch (Exception e) {

        }

    }

}
