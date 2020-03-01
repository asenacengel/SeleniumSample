package com.automation.tests.day01;

import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFirstSeleniumScript {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver();

        // open some website

        driver.get("http://google.com");

        WebDriverManager.edgedriver().setup();
        EdgeDriver fireFoxdriver = new EdgeDriver();
        fireFoxdriver.get("http://google.com");



    }
}
