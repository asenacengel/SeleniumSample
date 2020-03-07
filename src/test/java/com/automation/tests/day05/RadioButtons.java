package com.automation.tests.day05;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtons {
    public static void main(String[] args)  {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();

        BrowserUtils.wait(2);

        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));

        radioButtons.forEach(radiobutton ->{

            String id = radiobutton.getAttribute("id");
            if (radiobutton.isEnabled()) {
                radiobutton.click();
                System.out.println("Clicked on:: " + id);
                BrowserUtils.wait(1);
            }else {
                System.out.println("Button is disabled , not clicked : : "+id);
            }
        });

        driver.quit();
        }

    }

