package com.zjx.island.model;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2019/1/17
 */
public class OrderModel {
    String aviliableString;
    Boolean isAviliable;

    public String getAviliableString() {
        return aviliableString;
    }

    public void setAviliableString(String aviliableString) {
        this.aviliableString = aviliableString;
    }

    public Boolean getAviliable() {
        return isAviliable;
    }

    public void setAviliable(Boolean aviliable) {
        isAviliable = aviliable;
    }

    public OrderModel() {
        aviliableString = "";
        isAviliable = false;
    }

    @Override
    public String toString() {
        return "OrderModel{" +
            "aviliableString='" + aviliableString + '\'' +
            ", isAviliable=" + isAviliable +
            '}';
    }
}
