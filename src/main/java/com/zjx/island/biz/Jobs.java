package com.zjx.island.biz;

import com.zjx.island.biz.helper.PneumoniaBoard.PneumoniaAllBoard;
import com.zjx.island.biz.helper.PneumoniaBoard.PneumoniaData;
import com.zjx.island.biz.helper.PneumoniaBoard.PneumoniaDataCollector;
import com.zjx.island.biz.islanddeal.IslandAutomation;
import com.zjx.island.biz.moviequery.CinemaModel;
import com.zjx.island.biz.moviequery.QueryClass;
import com.zjx.island.biz.moviequery.QueryTicketModel;
import com.zjx.island.common.Constant;
import com.zjx.island.model.OrderModel;
import com.zjx.island.model.PersonModel;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
                IslandAutomation.deal(personModels.get(i));
            }
            hasOrdered = true;
//            EmailUtil.send("trevor.zhao@trustlife.com", orderModel.getAviliableString() + "当前时间" + df.format(new Date()), false,"晓岛目前可以预约啦");
        }
    }


//    @Scheduled(cron = "0 5 9,11,13,15,17,19,21,23 * * ?")
    @Scheduled(fixedDelay = 5 * ONE_MINUTE)
    public void xidanMovieJob() {
        logger.info("开始执行查询");

        List<CinemaModel> cinemaModelList = new ArrayList<>();
        cinemaModelList.add(new CinemaModel(Constant.CinemaConstants.CinemaName.LUMIAI, Constant.CinemaConstants.CinemaId.LUMIAI));
        cinemaModelList.add(new CinemaModel(Constant.CinemaConstants.CinemaName.LUMIAI, Constant.CinemaConstants.CinemaId.LUMIAI));

        QueryTicketModel queryTicketModel0 = new QueryTicketModel("冰雪奇缘2", "247949", cinemaModelList, new Date(2020, 2, 1));


        QueryClass queryClass = new QueryClass();
        queryClass.queryOneMovie(queryTicketModel0);

    }


//    @Scheduled(cron = "0 39,41,43 7 * * ?")
    public void busJob() {
        QueryClass queryClass = new QueryClass();
        List<String> urls = new ArrayList<>();
        urls.add("http://www.bjbus.com/home/ajax_rtbus_data.php?act=busTime&selBLine=597&selBDir=5657287355409450625&selBStop=15");
        urls.add("http://www.bjbus.com/home/ajax_rtbus_data.php?act=busTime&selBLine=325&selBDir=4813407732721612399&selBStop=16");
        queryClass.queryBus(urls);
    }

//    @Scheduled(fixedDelay = 60 * ONE_MINUTE)
    public void pneumoniaJob() {

        PneumoniaData pneumoniaData = new PneumoniaData();
        PneumoniaAllBoard pneumoniaAllBoard = new PneumoniaAllBoard(pneumoniaData);
//        PneumoniaBeijingBoard pneumoniaBeijingBoard = new PneumoniaBeijingBoard(pneumoniaData);

        PneumoniaDataCollector pneumoniaDataCollector = new PneumoniaDataCollector();

        PneumoniaData resultData = pneumoniaDataCollector.getResult();
        logger.info(resultData);
        pneumoniaData.setUntilTime(resultData.getUntilTime());
        pneumoniaData.setBeijingNums(resultData.getBeijingNums());
        pneumoniaData.setAllStatus(resultData.getAllStatus());
        pneumoniaData.dataChanged();
    }






    public static void main(String[] args) {
        try {
        } catch (Exception e) {

        }

    }

}
