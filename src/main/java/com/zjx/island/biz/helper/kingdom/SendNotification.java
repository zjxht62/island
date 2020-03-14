package com.zjx.island.biz.helper.kingdom;

/**
 * 所有观察者都有的行为 发送通知
 *
 * @author trevor.zhao
 * @date 2020/3/14
 */
public interface SendNotification {
    void sendNotification(ResourceInfoModel resourceInfoModel);
}
