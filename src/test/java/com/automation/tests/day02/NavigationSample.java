package com.automation.tests.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationSample {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();

        String url = "http://google.com";
        driver.get(url);
        Thread.sleep(5000);

        String url2 = "http://amazon.com";
        String title = driver.getTitle();
        driver.navigate().to(url2);
        Thread.sleep(3000);

        driver.navigate().back();
        Thread.sleep(3000);

        driver.navigate().forward();
        Thread.sleep(3000);

        driver.navigate().refresh();
        Thread.sleep(3000);



        driver.close();




    }
}
