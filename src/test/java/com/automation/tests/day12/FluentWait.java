package com.automation.tests.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class FluentWait {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.createADriver(DriverFactory.Browser.Chrome);


    }
    @Test
    public void fluentTest() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");
        //10, TimeUnit.SECONDS = Duration.ofSeconds(10)
//        Wait<WebDriver> wait = new FluentWait<>(driver).
//                withTimeout(Duration.ofSeconds(10)).
//                pollingEvery(Duration.ofSeconds(3)).
//                ignoring(NoSuchElementException.class);
//        WebElement submitBtn = wait.until(new Function<WebDriver, WebElement>() {
//            @Override
//            public WebElement apply(WebDriver webDriver) {
//                return driver.findElement(By.xpath("//button[text()='Submit']"));
//            }
//        });
   }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
