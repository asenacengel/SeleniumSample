package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {


    public enum Browser{
        Chrome,
        MicrosoftEdge,
        FireFox,
        Safari
    }
    public static WebDriver createADriver(Browser browser){

        WebDriver selectedDriver = null;
        switch (browser){
            case Chrome:
                WebDriverManager.chromedriver().setup();
                selectedDriver  = new ChromeDriver();
                break;
            case FireFox:
                WebDriverManager.firefoxdriver().setup();
                selectedDriver  = new FirefoxDriver();
                break;

            case MicrosoftEdge:
                WebDriverManager.edgedriver().setup();
                selectedDriver = new EdgeDriver();
                break;
            case Safari:

                selectedDriver = new SafariDriver();
                break;
        }

       return selectedDriver;
    }}

