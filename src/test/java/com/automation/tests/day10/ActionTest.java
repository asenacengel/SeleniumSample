package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionTest {

    private WebDriver driver;
    private Actions actions;

    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.createADriver(DriverFactory.Browser.Chrome);
        driver.manage().window().maximize();
        actions = new Actions(driver);

    }
    @Test
    public void hoverOnImage(){
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtils.wait(3);
        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));
        //build() is needed when you have couple of actions always end with perform()
        actions.moveToElement(img1).pause(1000).moveToElement(img2).pause(3000).moveToElement(img3).pause(1000).build().perform();

        //hover on the first images verify that "name : user1" is displayed
        WebElement imgtext1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        Assert.assertTrue(imgtext1.isDisplayed());
        BrowserUtils.wait(2);
        // move to second image
        actions.moveToElement(img2).perform();
        WebElement imgText2 = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        Assert.assertTrue(imgText2.isDisplayed());


    }
    @Test
    public void jqueryMenuTest(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu#");
      WebElement enabled =  driver.findElement(By.id("ui-id-3"));
      WebElement download = driver.findElement(By.id("ui-id-4"));
      WebElement pdf = driver.findElement(By.id("ui-id-5"));
      actions.moveToElement(enabled).pause(1000).moveToElement(download).pause(1000).click(pdf).perform();

    }
    @Test
    public void dragAndDropTest(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        BrowserUtils.wait(3);
        // for cookies
        driver.findElement(By.xpath("//button[text()='Accept Cookies']")).click();
        WebElement earth = driver.findElement(By.id("droptarget"));
        WebElement moon = driver.findElement(By.id("draggable"));

        actions.dragAndDrop(moon,earth).perform();
        String expected = "You did great!";
        String actual = earth.getText();
        Assert.assertEquals(actual, expected);

    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(2);
        driver.quit();
    }
}
