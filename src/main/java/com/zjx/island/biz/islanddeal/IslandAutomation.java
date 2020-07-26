package com.zjx.island.biz.islanddeal;

import com.zjx.island.model.PersonModel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2019/1/18
 */
public class IslandAutomation {
    public static void deal(PersonModel personModel) {

        BaseAutomation islandTest = new BaseAutomation();
        islandTest.beforeMethod();
        islandTest.getPage("http://xiaosongisland.com/yuyue.html");
        WebDriver webDriver = islandTest.getDriver();

        //显示等待10S防止一上来就疯狂点击
        WebElement myDynamicElement = (new WebDriverWait(webDriver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div.tcdiv2 > div.container > div > div > div > div.tcdiv2_nr4 > input")));

        //如果查找到元素 直接点击
        myDynamicElement.click();

        //选择晓岛
        webDriver.findElement(By.cssSelector("#form2 > ul > li:nth-child(1) > div.date-box")).click();
        webDriver.findElement(By.cssSelector("#form2 > ul > li:nth-child(1) > div.date-box > div > div > a")).click();

        //选择日期
        webDriver.findElement(By.cssSelector("#form2 > ul > li:nth-child(2) > div.date-box")).click();
        //选择最远的那个日期
        List<WebElement> dateList = webDriver.findElements(By.className("a-date"));
//        System.out.println("输出" + dateList.get(dateList.size() - 1).getText());
        dateList.get(dateList.size() - 1).click();

        //填写各种信息
        webDriver.findElement(By.id("name")).sendKeys(personModel.getName());
        webDriver.findElement(By.id("sfz")).sendKeys(personModel.getId());
        webDriver.findElement(By.id("tel")).sendKeys(personModel.getTel());
        webDriver.findElements(By.className("btn1")).get(1).click();
        //todo 抓取一下预约成功后的下一步元素
        try {
            System.out.println("开始休眠");
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

//        islandTest.justClick(webDriver, By.cssSelector("#form2 > div.yy_main1_5 > input"));
//        try {
//            System.out.println("开始休眠");
//            Thread.sleep(3000);
//        } catch (Exception e) {
//
//        }
        webDriver.findElement(By.cssSelector("#form2 > div.yy_main1_5 > input")).click();

////        webDriver.close();
    }

    public static void main(String[] args) {
        deal(new PersonModel("", "", ""));
    }
}
