package com.zjx.island.utils;

import com.dingtalk.chatbot.DingtalkChatbotClient;
import com.dingtalk.chatbot.SendResult;
import com.dingtalk.chatbot.demo.TestConfig;
import com.dingtalk.chatbot.message.TextMessage;
import com.zjx.island.misc.Constant;

import java.util.ArrayList;

/**
 * 钉钉机器人消息model
 *
 * @author trevor.zhao
 * @date 2019/3/13
 */
public class DingdingRobotUtil {

    public static DingtalkChatbotClient client = new DingtalkChatbotClient();

    public static void testSendTextMessage(String toSend, String robotUrl) throws Exception {
        TextMessage message = new TextMessage(toSend);
        SendResult result = client.send(robotUrl, message);
        System.out.println(result);
    }

    public static void testSendTextMessageWithAt() throws Exception {
        TextMessage message = new TextMessage("测试一下AT我自己");
        ArrayList<String> atMobiles = new ArrayList<String>();
        atMobiles.add("13241336315");
        message.setAtMobiles(atMobiles);

        SendResult result = client.send(TestConfig.CHATBOT_WEBHOOK, message);
        System.out.println(result);
    }

}
