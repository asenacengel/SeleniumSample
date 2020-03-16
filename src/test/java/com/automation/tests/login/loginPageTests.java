package com.automation.tests.login;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class loginPageTests {

    private WebDriver driver;
    private String URL ="https://qa2.vytrack.com/user/login";
    private String username = "storemanager85";
    private String password = "Useruser123";
    private By usernameBy = By.id("prependedInput");
    private By passwordby = By.id("prependedInput2");
    private By warningMessageBy = By.cssSelector("[class='alert alert-error']>div");

    @Test
    public void invalidUserName(){
        driver.findElement(usernameBy).sendKeys("invalidusername");
        driver.findElement(passwordby).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(3);
        WebElement warningElement = driver.findElement(warningMessageBy);
        assertTrue(warningElement.isDisplayed());

        String expected = "Invalid user name or password.";
        String actual = warningElement.getText();
        assertEquals(expected, actual);

    }
    @Test
    public void loginAsStoreManager(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordby).sendKeys(password,Keys.ENTER);
        BrowserUtils.wait(3);

    }

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
       if(driver !=null){
           driver.quit();
           driver = null;
       }
    }
}
