package com.zjx.island.biz.junitdemo;

/**
 * 测试是否为奇数
 *
 * @author trevor.zhao
 * @date 2020/12/16
 */
public class PrimeNumberChecker {
    public Boolean validate(final Integer primeNumber) {
        for (int i = 2; i < (primeNumber / 2); i++) {
            if (primeNumber % i == 0) {
                return false;
            }
        }
        return true;
    }
}
