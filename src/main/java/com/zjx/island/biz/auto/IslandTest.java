package com.zjx.island.biz.auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2019/1/18
 */
public class IslandTest extends BaseTest {

    public void getPage(String url) {
        driver.get(url);
    }

    public static void justClick(WebDriver driver, By selector) {
        boolean clicked = false;
        WebElement e = driver.findElement(selector);
        while (clicked == false) {
            try {
                System.out.println("尝试点击");
                e.click();
                clicked = true;
                Thread.sleep(100);
            } catch (Exception ex) {
                System.out.println("未能点击");
//                ex.printStackTrace();
                clicked = false;
            }
        }

    }

}
