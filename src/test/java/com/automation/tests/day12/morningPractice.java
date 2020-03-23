package com.automation.tests.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class morningPractice {

   private WebDriver driver;
   Action action;
   private String URL = "http://practice.cybertekschool.com/tables";

   @BeforeMethod
    public void setUp(){
       DriverFactory.createADriver(DriverFactory.Browser.Chrome);
       driver = new ChromeDriver();
       driver.get(URL);
       driver.manage().window().maximize();


   }
   @Test
   public void sortedNames(){
       driver.findElement(By.xpath("//table[1]//*[text()='Last Name']")).click();
       List<WebElement>  sorted = driver.findElements(By.xpath("//table[1]//tbody//td[1]"));
       sorted.forEach(sortedName -> System.out.println(sortedName.getText()));

       List<Integer> list = Arrays.asList(1, 1, 2, 3, 3, 4, 5, 5);
       System.out.println("The distinct elements are :");
       list.stream().distinct().forEach(System.out::println);

   }
   @Test
   public void waitForVisibility(){
       WebDriverWait wait = new WebDriverWait(driver, 10);
       driver.findElement(By.tagName("button")).click();
       WebElement userName = driver.findElement(By.name("username"));
       WebElement lastName = driver.findElement(By.name("password"));
       WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));

       wait.until(ExpectedConditions.visibilityOf(userName)).sendKeys("tomsmith");
       wait.until(ExpectedConditions.visibilityOf(lastName)).sendKeys("SuperSecretPassword");
       wait.until(ExpectedConditions.visibilityOf(submitBtn));
       wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();




   }

   @AfterMethod
    public void tearDown(){
       driver.quit();
   }
}
