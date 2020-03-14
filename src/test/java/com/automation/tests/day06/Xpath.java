package com.automation.tests.day06;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver(DriverFactory.Browser.Chrome);
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
        WebElement btn1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        btn1.click();

        WebElement result = driver.findElement(By.id("result"));
        System.out.println(result.getText());

        // click button 2
        WebElement button2 = driver.findElement(By.xpath("//button[text()='Button 2']"));
        button2.click();
        System.out.println(result.getText());

        // click button 3 //span[starts-with(@class,h1y')]
        WebElement button3 = driver.findElement(By.xpath("//button[starts-with(@id,'button_')]"));
        button3.click();
        System.out.println(result.getText());

        // click button 5
        WebElement button5 = driver.findElement(By.xpath("//button[contains(text(),'5')]"));
        button5.click();
        System.out.println(result.getText());


        BrowserUtils.wait(3);
        driver.quit();
    }
}
