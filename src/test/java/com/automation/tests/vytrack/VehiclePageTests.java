package com.automation.tests.vytrack;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VehiclePageTests {

    private String URL = "https://qa2.vytrack.com/user/login";
    //    CREDENTIALS FOR store manager
    private String username = "storemanager85";
    private String password = "UserUser123";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By fleetBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]");
    private By subtitleBy = By.className("oro-subtitle");
    private WebDriver driver;
    @Test
    public void verifyPageSubTitle(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(5);
        //click on fleet
       // driver.findElement(fleetBy).click();
        //Action class use for more advanced browser interactions.
        Actions actions = new Actions(driver);
        // move to element instead of click.
        actions.moveToElement(driver.findElement(fleetBy)).perform();

        BrowserUtils.wait(2);
        //click on Vehicles
        driver.findElement(By.linkText("Vehicles")).click();
        BrowserUtils.wait(5);
        WebElement subTitleElement = driver.findElement(subtitleBy);
        System.out.println(subTitleElement.getText());

        String expected = "All Cars";
        String actual = subTitleElement.getText();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void verifyPageNumber(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(5);
        driver.findElement(fleetBy).click();
        driver.findElement(By.linkText("Vehicles")).click();
        BrowserUtils.wait(5);
        WebElement pageNumber = driver.findElement(By.cssSelector("input[type='number']"));

        String expected2 = "1";
        String actual2 = pageNumber.getAttribute("value");
        Assert.assertEquals(expected2, actual2);

    }
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown() {
        //if webdriver object alive
        if (driver != null) {
            //close browser, close session
            driver.quit();
            //destroy webdriver object for sure
            driver = null;
        }
    }
}
