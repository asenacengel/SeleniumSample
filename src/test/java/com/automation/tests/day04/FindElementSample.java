package com.automation.tests.day04;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementSample {
    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.imdb.com/");
        driver.findElement(By.id("suggestion-search")).sendKeys("Titanic");
        driver.findElement(By.id("suggestion-search")).submit();
//        driver.findElement(By.linkText("Titanic")).submit();
//        driver.findElement(By.id("suggestion-search-button")).submit();

        Thread.sleep(5000);
        WebElement result = driver.findElement(By.className("findHeader")).findElement(By.className("findSearchTerm"));
        System.out.println(result   );
        Thread.sleep(2000);
        driver.quit();


    }
}
