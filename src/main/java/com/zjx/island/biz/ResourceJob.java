package com.zjx.island.biz;

import com.zjx.island.biz.excel.ExcelWriter;
import com.zjx.island.biz.helper.PneumoniaBoard.PneumoniaAllBoard;
import com.zjx.island.biz.helper.PneumoniaBoard.PneumoniaData;
import com.zjx.island.biz.helper.PneumoniaBoard.PneumoniaDataCollector;
import com.zjx.island.biz.helper.kingdom.*;
import com.zjx.island.biz.islanddeal.IslandAutomation;
import com.zjx.island.biz.moviequery.Cinema;
import com.zjx.island.biz.moviequery.QueryHandler;
import com.zjx.island.biz.moviequery.QueryTicketModel;
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
public class ResourceJob {
    public static final long ONE_MINUTE = 60 * 1000;
    public static Boolean hasOrdered = false;
    private static final Logger logger = Logger.getLogger(ResourceJob.class);
    private ResourceDataCollector resourceDataCollector;
    private ResourceData resourceData;

    public ResourceJob() {
        this.resourceDataCollector = new ResourceDataCollector();
        this.resourceData = new ResourceData();
        S02E01Observer s02E01Observer = new S02E01Observer(resourceData);
        S02E02Observer s02E02Observer = new S02E02Observer(resourceData);
        S02E03Observer s02E03Observer = new S02E03Observer(resourceData);
        S02E04Observer s02E04Observer = new S02E04Observer(resourceData);
        S02E05Observer s02E05Observer = new S02E05Observer(resourceData);
        S02E06Observer s02E06Observer = new S02E06Observer(resourceData);
    }

    @Scheduled(fixedDelay = 10* 1000)
//    @Scheduled(fixedDelay = 1 * ONE_MINUTE)
    public void kingdomJob() {

        resourceData.setResourceInfoModelMap(resourceDataCollector.getResult());

    }




}
