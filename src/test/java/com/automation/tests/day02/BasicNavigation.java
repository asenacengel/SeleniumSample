package com.automation.tests.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BasicNavigation {
    public static void main(String[] args) {
        //to start selenium script
        //setup webdriver (browser driver) and create webdriver object

        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();

        // in selenium , everything starts from webdriver interface

        driver.get("http://google.com");    // to open website



    }
}
