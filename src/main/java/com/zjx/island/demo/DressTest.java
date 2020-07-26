package com.zjx.island.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2020/6/23
 */
public class DressTest {

    public static void main(String[] args) {
        Dress dress1 = new Dress("贝壳", Constants.DressType.JSK);
        Dress dress2 = new Dress("BabyDoll", Constants.DressType.JSK);
        Dress dress3 = new Dress("迷雾仙境", Constants.DressType.OP);
        Dress dress4 = new Dress("夏葵", Constants.DressType.OP);

        List<Dress> dresses = new ArrayList<>();
        dresses.add(dress1);
        dresses.add(dress2);
        dresses.add(dress3);
        dresses.add(dress4);

        System.out.println(dresses);

        List<Dress> opDresses = dresses.stream().filter(dress -> dress.getType().equals(Constants.DressType.OP)).collect(Collectors.toList());
        System.out.println(opDresses);

        opDresses.stream().forEach(System.out::println);
    }


}
