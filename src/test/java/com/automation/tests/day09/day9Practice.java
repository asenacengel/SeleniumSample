package com.automation.tests.day09;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class day9Practice {

    private WebDriver driver;

    @BeforeMethod
    public void beforeSetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com");
        BrowserUtils.wait(3);

    }
    @Test
    public void input(){
        driver.findElement(By.tagName("Inputs")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.name("number")).sendKeys("123345",Keys.ENTER);
        BrowserUtils.wait(3);

    }
    @AfterMethod
    public void afterTest(){
        driver.close();
    }

}
