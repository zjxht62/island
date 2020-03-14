package com.zjx.island.biz.helper.kingdom;

import java.util.ArrayList;
import java.util.Map;

/**
 * 资源数据 被观察者
 *
 * @author trevor.zhao
 * @date 2020/3/14
 */
public class ResourceData implements Subject {
    private ArrayList observers;
    private Map<String, ResourceInfoModel> resourceInfoModelMap;

    public ResourceData() {
        observers = new ArrayList();
    }

    public void dataChanged() {
        notifyObserver();
    }

    public Map<String, ResourceInfoModel> getResourceInfoModelMap() {
        return resourceInfoModelMap;
    }

    public void setResourceInfoModelMap(Map<String, ResourceInfoModel> resourceInfoModelMap) {
        this.resourceInfoModelMap = resourceInfoModelMap;
        dataChanged();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer)observers.get(i);
            observer.update(resourceInfoModelMap);
        }
    }
}
