package com.zjx.island.biz.helper.PneumoniaBoard;

import com.zjx.island.common.Constant;
import com.zjx.island.utils.DingdingRobotUtil;

import java.util.Observable;
import java.util.Observer;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2020/1/22
 */
public class PneumoniaBeijingBoard implements Observer, BaseBoard {

    public PneumoniaBeijingBoard(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof PneumoniaData) {
            PneumoniaData pneumoniaData = (PneumoniaData)o;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(pneumoniaData.getUntilTime());
            stringBuilder.append("\n");
            stringBuilder.append(pneumoniaData.getBeijingNums());
            sendDingMessage(stringBuilder.toString());
        }


    }

    @Override
    public void sendDingMessage(String message) {
        try {
            DingdingRobotUtil.testSendTextMessage(message, Constant.url.MOVIE_ROBOT_URL);
        } catch (Exception e) {

        }


    }
}
