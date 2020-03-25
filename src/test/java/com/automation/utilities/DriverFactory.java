package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    private static WebDriver driver;


    public enum Browser{
        Chrome,
        MicrosoftEdge,
        FireFox,
        Safari
    }
    public static WebDriver createADriver(Browser browser){

if(driver !=null){
    return driver;
}
        switch (browser){
            case Chrome:
                WebDriverManager.chromedriver().setup();
                driver  = new ChromeDriver();
                break;
            case FireFox:
                WebDriverManager.firefoxdriver().setup();
                driver  = new FirefoxDriver();
                break;

            case MicrosoftEdge:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case Safari:

                driver = new SafariDriver();
                break;
        }

       return driver;
    }


}





