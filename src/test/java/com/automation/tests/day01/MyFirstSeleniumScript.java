package com.automation.tests.day01;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;

public class MyFirstSeleniumScript {
    public static void main(String[] args) {

//        //Chrome Driver
//        WebDriverManager.chromedriver().setup();
//
//        ChromeDriver driver = new ChromeDriver();
//
//
//        //Edge Driver
//        driver.get("http://google.com");
//
//        WebDriverManager.edgedriver().setup();
//        EdgeDriver fireFoxdriver = new EdgeDriver();
//        fireFoxdriver.get("http://google.com");


       WebDriver driver =  DriverFactory.createADriver(DriverFactory.Browser.Safari);
        driver.get("http://google.com");

    }
}
