package com.automation.tests.day06;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver(DriverFactory.Browser.Chrome);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        buttons.get(0).click();   // for first button
        BrowserUtils.wait(2);

        String popUpText = driver.switchTo().alert().getText();
        System.out.println(popUpText);
        driver.switchTo().alert().accept();  // To click OK
        String expected = "You successfuly clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();

        if(expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            System.out.println("Expected: "+expected);
            System.out.println("Actual: "+actual);
        }

        buttons.get(1).click();  // To click for second button
        BrowserUtils.wait(2);
        driver.switchTo().alert().dismiss();

        String expected2 = "You clicked: Cancel";
        String actual2 = driver.findElement(By.id("result")).getText();

        if(expected2.equals(actual2)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            System.out.println("Expected: "+expected2);
            System.out.println("Actual: "+actual2);

        }

        buttons.get(2).click();
        BrowserUtils.wait(2);
        driver.switchTo().alert().dismiss();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello,World");
        alert.accept();   // click ok


        String expected3 = "Hello,World";
        String actual3 = driver.findElement(By.id("result")).getText();

        if(expected3.equals(actual3)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("YOUR TEST SUCCESSFULLY FAILED :)");
            System.out.println("Expected: "+expected3);
            System.out.println("Actual: "+actual3);
        }

        BrowserUtils.wait(3);
        driver.quit();

    }
}
