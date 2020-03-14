package com.zjx.island.biz.helper.kingdom;

import com.google.common.reflect.ClassPath;

import java.util.Map;

/**
 * 观察者接口
 *
 * @author trevor.zhao
 * @date 2020/2/28
 */
public interface Observer {
    /**
     * 主题调用这个方法通知观察者更新状态
     */
    void update(Map<String, ResourceInfoModel> resourceInfoModelMap);
}
