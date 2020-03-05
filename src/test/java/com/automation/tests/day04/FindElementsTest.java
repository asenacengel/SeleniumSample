package com.automation.tests.day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsTest {
    public static void main(String[] args)throws Exception {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");

        Thread.sleep(3000);

        // HOW TO COLLECTS ALL THE LINKS FROM THE PAGE?
        List<WebElement> link = driver.findElements(By.tagName("a"));

        for (WebElement element : link) {
            System.out.println(element.getText());
            System.out.println(element.getAttribute("href"));
            System.out.println();
        }

        for (int i = 0; i <link.size() ; i++) {
            link.get(i).click();

            driver.navigate().back();
            link = driver.findElements(By.tagName("a"));
        }

            ;// link.forEach(links -> System.out.println());



        driver.quit();
    }
}
