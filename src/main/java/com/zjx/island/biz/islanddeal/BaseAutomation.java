package com.zjx.island.biz.islanddeal;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

//import org.junit.BeforeClass;

public class BaseAutomation {
	public static WebDriver driver = setDriver();
//	public static JavascriptExecutor jsExecutor = (JavascriptExecutor)setDriver();
//	public static BasePageUtil util= new BasePageUtil(driver, log);
//	public static ConfigsUtil env=new ConfigsUtil("configs/env.properties");
//	public MyAssertion myassert=new MyAssertion(util);
//	@BeforeMethod
	public static void beforeMethod() {
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	public static WebDriver setDriver() {
		System.setProperty("webdriver.chrome.driver","configs/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}

    public void getPage(String url) {
        driver.get(url);
    }

	public static WebDriver getDriver() {
		return driver;
	}
}
