package com.automation.tests.day03;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementById {
    public static void main(String[] args)throws Exception {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(2000);

       WebElement password = driver.findElement(By.name("password"));
       password.sendKeys("SuperSecretPassword");

       Thread.sleep(3000);

       driver.findElement(By.id("wooden_spoon")).click();
       Thread.sleep(2000);

       String expected ="Welcome to the Secure Area. When you are done click logout below.";
       String actual = driver.findElement(By.tagName("h4")).getText();
       if(expected.equals(actual)){
           System.out.println("TEST PASSED");
       }else{
           System.out.println("TEST FAILED");
       }
       Thread.sleep(2000);

       // lets click on logout button.it looks like a button its actually link.every element with <a> is a link.
        // if you have couple space in the text,just use partialLinkText instead of linktext.
        WebElement logout = driver.findElement(By.linkText("Logout"));

        String href = logout.getAttribute("href");
        System.out.println(href);
        logout.click();
        Thread.sleep(3000);
      //  String className = logout.getAttribute("class");
       // System.out.println(className);

        // Lets enter invalid credentials.
        driver.findElement(By.name("username")).sendKeys("wrong");
        driver.findElement(By.name("password")).sendKeys("wrong");
        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(3000);
        WebElement errorMessage = driver.findElement(By.id("flash-messages"));
        System.out.println(errorMessage.getText());



        Thread.sleep(3000);
        driver.quit();



    }
}
