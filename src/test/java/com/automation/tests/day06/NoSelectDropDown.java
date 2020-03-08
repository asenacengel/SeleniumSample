package com.automation.tests.day06;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NoSelectDropDown {
    public static void main(String[] args) {

        WebDriver driver =  DriverFactory.createADriver(DriverFactory.Browser.Chrome);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        driver.findElement(By.id("dropdownMenuLink")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Amazon")).click();

        List<WebElement> links = driver.findElements(By.className("dropdown-item"));

        links.forEach(allLinks -> System.out.println(allLinks.getText()+allLinks.getAttribute("href")));
        driver.findElement(By.linkText("Etsy"));




        BrowserUtils.wait(3);
        driver.quit();
    }
}
