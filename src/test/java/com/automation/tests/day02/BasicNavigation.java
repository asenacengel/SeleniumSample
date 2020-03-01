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
        driver.manage().window().maximize();  // to maximize browser.
        driver.manage().window().fullscreen();

        Thread.sleep(3000);   // for demo , wait 3 seconds.

            String title = driver.getTitle();  // returns <title>Some title</title> text

        System.out.println("title is : "+title);


        String expectedTitle = "Google";
        if(title.equals(expectedTitle)){
            System.out.println("Test is passed");
        }else{

            System.out.println("Test is Failed");
        }

        driver.navigate().to("http://amazon.com");

        if(driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("TEST PASSED!");

        }else {
            System.out.println("TEST FAILED");
        }

        // come back to google
        driver.navigate().back();
        verifyEquals(driver.getTitle(), "Google");
        // move forward in the browser history
        driver.navigate().forward();
        System.out.println("Title: "+driver.getTitle());
        // driver.gettitle () returns page title of the page that is currently opened

        driver.navigate().refresh();   // to reload the page
        Thread.sleep(3000);     // for demo wait 3 seconds

        driver.close();  // to close browser  browser cant close itself



    }

    public static void verifyEquals(String arg1,String arg2){
        if(arg1.equals(arg2)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
    }
}
