package com.zjx.island.biz.helper.kingdom;


import org.apache.log4j.Logger;

import java.util.Map;

/**
 * 第二季第五集
 *
 * @author trevor.zhao
 * @date 2020/2/29
 */
public class S02E05Observer implements Observer, SendNotification {
    private static final Logger logger = Logger.getLogger(S02E05Observer.class);
    private ResourceData resourceData;
    private float temperature;
    private float humidity;

    public S02E05Observer(ResourceData resourceData) {
        this.resourceData = resourceData;
        resourceData.registerObserver(this);
    }

    @Override
    public void update(Map<String, ResourceInfoModel> resourceInfoModelMap) {
        logger.info("被通知啦" + this.getClass().getName());
        ResourceInfoModel s02e01Model = resourceInfoModelMap.get("S02E05");
        if (s02e01Model.getDownloadable()) {
            sendNotification(s02e01Model);
            resourceData.removeObserver(this);
        }

    }

    @Override
    public void sendNotification(ResourceInfoModel resourceInfoModel) {
        logger.info("发送通知S02E01" + resourceInfoModel.toString());
    }

}
