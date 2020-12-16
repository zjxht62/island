package com.zjx.island.biz.junitdemo;

/**
 * 测试断言
 *
 * @author trevor.zhao
 * @date 2020/12/15
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class TestAssertions {
    @Test
    public void testAssertions() {
        //测试数据
        //创建的str1放到堆中
        String str1 = new String("abc");
        String str2 = new String("abc");
        String str3 = null;
        //在栈中创建一个对象引用变量str,然后查看字符串池中是否存在”abc”，如果没有，则将”abc”存放字符串池，并令引用变量str指向它；如果已经有”abc”，则直接令str指向它。
        String str4 = "abc";
        String str5 = "abc";
        int val1 = 5;
        int val2 = 6;
        String[] exceptedArray = {"one", "two", "three"};
        String[] resultArray = {"one", "two", "three"};

        //测试两个对象是否相等
        assertEquals(str1, str2);

        //测试条件
        assertTrue(val1 < val2);
        assertFalse(val1 > val2);

        //判断为空
        assertNull(str3);

        //判断两个对象是否指向同一引用
        assertSame(str4, str5);

        //判断两个对象不是指向同一引用
        assertNotSame(str1, str4);

        //判断数组是否相等
        assertArrayEquals(exceptedArray, resultArray);



    }
}
