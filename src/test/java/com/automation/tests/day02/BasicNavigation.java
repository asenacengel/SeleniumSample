package com.automation.tests.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception{
        //to start selenium script
        //setup webdriver (browser driver) and create webdriver object

        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();

        // in selenium , everything starts from webdriver interface
        // Chromedriver extends RemoteWebDriver --> implements Webdriver.

        driver.get("http://google.com");    // to open website

        Thread.sleep(3000);   // for demo , wait 3 seconds.

            String title = driver.getTitle();  // returns <title>Some title</title> text

        System.out.println("title is : "+title);


        String expectedTitle = "Google";
        if(title.equals(expectedTitle)){
            System.out.println("Test is passed");
        }else{

            System.out.println("Test is Failed");
        }

        driver.close();  // to close browser  browser cant close itself







    }
}
