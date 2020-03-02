package com.automation.tests.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args)throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(2000);
        // name - its one of the selenium locators there are 8 locators we use locators to find elements.to choose locator just use By.name
        WebElement search = driver.findElement(By.name("q"));
        // once we found and element how to enter a text?
        // To enter text use sendKeys() method
        // how to press Enter after entering the text?
        // use Key.ENTER
        // Keys.ENTER - perform keyboard click.
        search.sendKeys("Java", Keys.ENTER);
        Thread.sleep(2000);

        WebElement news = driver.findElement(By.linkText("News"));
        Thread.sleep(4000);
        news.click();

        driver.quit();

    }
}
