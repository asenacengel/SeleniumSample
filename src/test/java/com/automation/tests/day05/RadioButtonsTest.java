package com.automation.tests.day05;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonsTest {
    public static void main(String[] args) {

      WebDriver driver =  DriverFactory.createADriver(DriverFactory.Browser.Chrome);
      driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        WebElement blackButton = driver.findElement(By.id("black"));
        blackButton.click();

        // how do we verify that button clicked?
        if(blackButton.isSelected()){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }


        driver.quit();

    }
}
