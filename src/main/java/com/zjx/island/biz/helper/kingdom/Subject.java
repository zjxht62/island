package com.zjx.island.biz.helper.kingdom;

/**
 * 观察者模式的主题
 *
 * @author trevor.zhao
 * @date 2020/2/28
 */
public interface Subject {
    /**
     * 注册观察者
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察者
     */
    void removeObserver(Observer observer);

    /**
     * 通知观察者
     */
    void notifyObserver();
}
