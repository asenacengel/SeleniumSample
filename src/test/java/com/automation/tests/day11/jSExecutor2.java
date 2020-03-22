package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class jSExecutor2 {

    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.createADriver(DriverFactory.Browser.Chrome);
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();

    }
    @Test
    public void verifyTitle(){
        String expected = "Practice";
        // we create javaScript execute object by casting webdriver object
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //executeScript - this method executes javascript code
        // we provide js code as a string
        // return document.title -javascript code
        // document represents HTML page
        // .toString() - to avoid additional casting from Object to String
       String actual =  js.executeScript("return document.title").toString();
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void clickTest(){
        WebElement link = driver.findElement(By.linkText("Multiple Buttons"));
       //disable the click action to perform it with js executer
        // link.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // use index to get specific webelement
        js.executeScript("arguments[0].click()", link);
        WebElement button6 = driver.findElement(By.id("disappearing_button"));
        js.executeScript("arguments[0].click()",button6);
        BrowserUtils.wait(2);
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(), "Now it's gone!");

    }
    @Test
    public void textInputTest(){
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(2);
        WebElement userName = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.id("wooden_spoon"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // to get text from input box read attribute "value"
        // to enter text - set attribute "value"
        js.executeScript("arguments[0].setAttribute('value', 'tomsmith') ",userName);
        js.executeScript("arguments[0].setAttribute('value', 'SuperSecretPassword')",password);
        js.executeScript("arguments[0].click()",loginButton);
        BrowserUtils.wait(2);
        String subHeader = js.executeScript("return document.getElementsByClassName('subheader')[0].textContent").toString();
    }
    @Test
    public void scrollToElement(){
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",link);

    }
    @Test
    public void scrollTest(){
        driver.navigate().to("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i<15;i++){

        }
    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(2);
        driver.quit();
    }
}
