package com.cbt.utilities;
import org.openqa.selenium.WebDriver;

import java.util.*;

public class TitleVerification2 {
    public static void main(String[] args) throws Exception {
        List<String> urls = Arrays.asList(
                "https://lulugandgeorgia.com",
                "https://wayfair.com/",
                "https://walmart.com",
                "https://westelm.com");

        WebDriver driver = BrowserFactory.getDriver("chrome");

        for (int i = 0; i < urls.size(); i++) {
            driver.get(urls.get(i));
            Thread.sleep(3000);
            if(urls.get(i).contains(driver.getTitle().replace(" ","").toLowerCase())){
                System.out.println(driver.getTitle() + " - PASS");
            }else{
                System.out.println(driver.getTitle() + " - FAIL");
            }
        }

        driver.quit();
    }

}
