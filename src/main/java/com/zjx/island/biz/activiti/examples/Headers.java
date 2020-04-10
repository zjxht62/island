package com.zjx.island.biz.activiti.examples;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * 请求头部
 *
 * @author trevor.zhao
 * @date 2020/4/3
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY,property = "@class")
public class Headers {
    private String key;
    private String value;




    @JsonCreator
    public Headers(@JsonProperty("key")String key, @JsonProperty("value") String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Headers{" +
            "key='" + key + '\'' +
            ", value='" + value + '\'' +
            '}';
    }
}
