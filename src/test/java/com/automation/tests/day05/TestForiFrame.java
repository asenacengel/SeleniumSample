package com.automation.tests.day05;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestForiFrame {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver(DriverFactory.Browser.Chrome);
        driver.get("http://practice.cybertekschool.com/iframe");
        driver.manage().window().maximize();

        BrowserUtils.wait(2);
        // Before looking for that element, we need to jump to that frame
        // Y ou can specify : name,id , index or web element of the frame
        // its like we are jumping to another layer
        driver.switchTo().frame("mce_0_ifr");
        // now , this content will be visible
        WebElement textInput = driver.findElement(By.id("tinymce"));
        System.out.println(textInput.getText());

        BrowserUtils.wait(3);
        textInput.clear();   // to delete a text
        textInput.sendKeys("Hello , World");
        BrowserUtils.wait(3);

        // exit from the frame
        driver.switchTo().defaultContent();
        WebElement heading = driver.findElement(By.tagName("H3"));
        System.out.println(heading);
        driver.quit();
    }
}
