package com.automation.tests.day07;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XPath {

    public static String userNameLocator = "//label[text()='Username']/following-sibling::input";
    public static String passwordLocator = "//label[text()='Password']/following-sibling::input";
    public static String loginBtnLocator = "//button[contains(text(), 'Login')]";


    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver(DriverFactory.Browser.Chrome);
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        driver.findElement(By.xpath(userNameLocator)).sendKeys("tomsmith");
        driver.findElement(By.xpath(passwordLocator)).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath(loginBtnLocator)).click();





        BrowserUtils.wait(2);
        driver.quit();
    }
}
