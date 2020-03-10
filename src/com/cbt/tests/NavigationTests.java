package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {
    public static void main(String[] args) throws Exception{
        TestMethod("chrome");
        TestMethod("firefox");
        TestMethod("edge");
    }

    public static void TestMethod(String browser) throws Exception {
        WebDriver driver = BrowserFactory.getDriver(browser);
        driver.get("http://google.com");
        Thread.sleep(3000);
        String titleGoogle = driver.getTitle();

        driver.get("http://etsy.com");
        Thread.sleep(3000);
        String titleEtsy = driver.getTitle();

        driver.navigate().back();
        Thread.sleep(3000);
        StringUtility.verifyEquals(driver.getTitle(), titleGoogle);

        driver.navigate().forward();
        Thread.sleep(3000);
        StringUtility.verifyEquals(driver.getTitle(),titleEtsy);

        driver.quit();
    }

}
