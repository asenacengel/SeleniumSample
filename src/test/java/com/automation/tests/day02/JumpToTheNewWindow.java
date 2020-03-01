package com.automation.tests.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {
    public static void main(String[] args)  throws Exception{
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(5000);

        // every windows has some id,this id calls window handle
        // based on window handle we can switch in between windows

        String windowHandle = driver.getWindowHandle();

        System.out.println(windowHandle);
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
        // getWindowHandles() - return id s of all currently opened windows

        // since we have all windows
        // and we know id of original window
        // we can switch to something that is not equals to old window id

        for(String windowId  : windowHandles){
            if(!windowId.equals(windowHandle)){
                driver.switchTo().window(windowId);
                System.out.println("AFTER SWITCH : "+driver.getCurrentUrl());
                driver.close();
            }
        }

    }

    public static void switchToWindowBasedOnTitle(String pagetitle,WebDriver driver){
        Set<String>windows = driver.getWindowHandles();
        for(String window  : windows){
            driver.switchTo().window(window);
            if(driver.getTitle().equals(pagetitle)){
                break;
            }
        }
    }
}
