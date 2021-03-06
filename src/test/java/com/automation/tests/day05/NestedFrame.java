package com.automation.tests.day05;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NestedFrame {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver(DriverFactory.Browser.Chrome);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/nested_frames");
        BrowserUtils.wait(3);

      driver.switchTo().frame("frame-top");
      driver.switchTo().frame("frame-middle");
        WebElement content = driver.findElement(By.id("content"));   // content inside a child frame
        System.out.println(content.getText());

        driver.switchTo().parentFrame();     // go to the top frame.
        driver.switchTo().frame("frame-right");  // switch to the right frame

        WebElement body = driver.findElement(By.tagName("body"));
        System.out.println(body.getText());

        // to go to the bottom frame , you need to switch to default content
        //because , top frame is a sibling for bottom frame but not a parent

        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.tagName("body")).getText());

        driver.quit();


        }
    }

