package com.cbt.utilities;
import org.openqa.selenium.WebDriver;

import java.util.*;

public class TitleVerification {
    public static void main(String[] args) throws Exception {
        List<String> urls = Arrays.asList(
                "http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get(urls.get(0));
        Thread.sleep(3000);
        String title1 = driver.getTitle();

        driver.get(urls.get(1));
        Thread.sleep(3000);
        String title2 = driver.getTitle();


        driver.get(urls.get(2));
        Thread.sleep(3000);
        String title3 = driver.getTitle();

        StringUtility.verifyEquals(title2, title1);
        StringUtility.verifyEquals(title3, title2);
        StringUtility.verifyEquals(title1, title3);

        if(urls.get(0).startsWith("http://practice.cybertekschool.com") && (urls.get(1).startsWith("http://practice.cybertekschool.com")) && (urls.get(2).startsWith("http://practice.cybertekschool.com"))){
            System.out.println("PASS - all urls starts with practice.cybertekschool.com");
        }else{
            System.out.println("FAIL - urls don't start with practice.cybertekschool.com");
        }

        driver.quit();

    }
}
