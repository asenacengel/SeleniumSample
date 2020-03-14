package com.automation.tests.day09;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {

    private WebDriver driver;
    @Test
    public void googleSearchTest(){
        driver.get("http://google.com");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(3);
        // SINCE EVERY  SEARCH ITEM HAS A TAG NAME <h3>
        // it is the easiest way to collect all of them
        List<WebElement> searchItem = driver.findElements(By.tagName("h3"));
        for(WebElement eachSearch : searchItem){
            String var = eachSearch.getText();
            if (!var.isEmpty()){
                System.out.println(var);
                //verify thar search result contain java
                //is some of the search result
                //does not contain java word it will fail the test


                Assert.assertTrue(var.toLowerCase().contains("java"));
            }
        }


    }

    @Test (description = "Seach for Java book on amazon")
    public void amazonSearchTest(){
        driver.get("http://amazon.com");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java",Keys.ENTER);
        BrowserUtils.wait(3);
        List<WebElement> searchItems = driver.findElements(By.xpath("//h2//a"));
        for(WebElement searchItem : searchItems){
            System.out.println("Title: "+searchItem.getText());
        }
        searchItems.get(0).click();
        BrowserUtils.wait(2);
        WebElement productTitle = driver.findElement(By.id("title"));
        String productTitleStr = productTitle.getText();
        System.out.println(productTitleStr);

        Assert.assertTrue(productTitleStr.contains("Java"));

    }
    @BeforeMethod
    // for set-up driver
    public void setUp(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown(){
        // close browser and destroy webdriver
        driver.close();
    }
}
