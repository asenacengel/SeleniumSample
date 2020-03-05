package com.automation.tests.day04;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WarmUpTask {
    public static void main(String[] args) throws Exception{

        WebDriver driver = DriverFactory.createADriver(DriverFactory.Browser.Chrome);
        driver.get("https://www.ebay.com/");
      driver.findElement(By.id("gh-ac")).sendKeys("java book");
      driver.findElement(By.id("gh-btn")).submit();

       WebElement searchResult =  driver.findElement(By.tagName("h1"));
        System.out.println(searchResult.getText());
        Thread.sleep(2000);
        driver.quit();


        WebDriver driver1 = DriverFactory.createADriver(DriverFactory.Browser.Chrome);
        driver1.get("http://amazon.com");
        driver1.findElement(By.id("twotabsearchtextbox")).sendKeys("java book",Keys.ENTER);
        String title = driver1.getTitle();
        if(title.contains("java book")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        driver1.quit();

        WebDriver driver2 = DriverFactory.createADriver(DriverFactory.Browser.Chrome);
        driver2.get("http://wikipedia.org");
        driver2.findElement(By.id("searchInput")).sendKeys("Selenium webdriver",Keys.RETURN);
        Thread.sleep(3000);
        driver2.findElement(By.partialLinkText("Selenium(software)")).click();
        Thread.sleep(2000);

        String link = driver2.getCurrentUrl();

        driver2.quit();









    }
}
