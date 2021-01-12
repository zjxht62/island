package com.zjx.island.demo.enumdemo;

/**
 * 笔类
 *
 * @author trevor.zhao
 * @date 2021/1/12
 */
public class Pen {
    //价格
    private double price;
    //颜色
    private Color color;

    public Pen(double price, Color color) {
        this.price = price;
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Pen{" +
            "price=" + price +
            ", color=" + color +
            '}';
    }
}
