package com.automation.tests.day05;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploading {
    public static void main(String[] args) {

WebDriver driver = DriverFactory.createADriver(DriverFactory.Browser.Chrome);
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/upload");

        BrowserUtils.wait(3);
        WebElement upload = driver.findElement(By.id("file-upload"));
        String filePath = System.getProperty("user.dir")+"/pom.xml";
        upload.sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();



        BrowserUtils.wait(3);
        driver.quit();
    }
}
