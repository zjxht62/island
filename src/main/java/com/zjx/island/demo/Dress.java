package com.zjx.island.demo;

/**
 * 裙子
 *
 * @author trevor.zhao
 * @date 2020/6/23
 */
public class Dress {
    private String name;
    private Integer type;

    public Dress() {
    }

    public Dress(String name, Integer type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Dress{" +
            "name='" + name + '\'' +
            ", type=" + type +
            '}';
    }
}
