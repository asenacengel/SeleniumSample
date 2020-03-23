package com.automation.tests.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class webOrders {
    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createADriver(DriverFactory.Browser.Chrome);
        wait = new WebDriverWait(driver, 10);

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);
    }
    @Test
    public void chechBoxedTest(){
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        List<WebElement> checkbox = driver.findElements(By.cssSelector("input[type='checkbox']"));
        checkbox.forEach(eachbox-> Assert.assertTrue(eachbox.isSelected()));

    }
    @Test
    public void zipcode(){
        WebElement zipcode = driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td[7]"));
        Assert.assertEquals(zipcode.getText(), "21233");
        //click on update image
        driver.findElement(By.xpath(" //td[text()='Steve Johns']//following-sibling::td/input")).click();
        WebElement zipcodeInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        zipcodeInput.clear();
        zipcodeInput.sendKeys("20002");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
        zipcode = driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td[7]"));
        Assert.assertEquals(zipcode.getText(), "20002");
    }
    @BeforeMethod
    public void tearDown(){


    }
}
