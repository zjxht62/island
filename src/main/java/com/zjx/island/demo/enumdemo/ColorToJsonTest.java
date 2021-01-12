package com.zjx.island.demo.enumdemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 测试将枚举类型的Color转为JsonString
 *
 * @author trevor.zhao
 * @date 2021/1/12
 */
public class ColorToJsonTest {
    public static void main(String[] args) {
        Pen redPen = new Pen(1.99, Color.RED);
        Pen greenPen = new Pen(1.98, Color.GREEN);
        Pen bluePen = new Pen(1.97, Color.BLUE);

        //默认会调用name()方法返回来进行序列化
        System.out.println(JSON.toJSONString(redPen));

        //使用枚举的ordinal()方法返回值来进行序列化
        int features=SerializerFeature.config(JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.WriteEnumUsingName, false);
        System.out.println(JSON.toJSONString(greenPen,features,SerializerFeature.EMPTY));

        //使用枚举的toString()方法返回来序列化
        System.out.println(JSON.toJSONString(bluePen, SerializerFeature.WriteEnumUsingToString));
    }
}
