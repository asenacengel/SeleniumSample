package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class webTables {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().version("79").setup();

        driver = DriverFactory.createADriver(DriverFactory.Browser.Chrome);
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
    }
    @Test
    public void getColumnNames(){
        List<String> expected = Arrays.asList("Last Name","First Name","Email","Due","Web Site","Action");
        List<WebElement> list =  driver.findElements(By.xpath("//table[1]//th"));
        list.forEach(eachElement -> System.out.println(eachElement.getText()));
        Assert.assertEquals(BrowserUtils.getTextFromWebElements(list), expected);


    }
    @Test
    public void verifyRowCount(){
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        Assert.assertEquals(rows.size(),4);

    }
    @Test
    public void getSpecificColumn(){
        List<WebElement> links = driver.findElements(By.xpath("table[1]//tbody//tr//td[5]"));
        System.out.println(BrowserUtils.getTextFromWebElements(links));
    }
    @Test
    public void deleteRowTest(){
    String xpath ="//table[1]//td[text()='jsmith@gmail.com']/..//a[text()='delete']";
    driver.findElement(By.xpath(xpath)).click();

    int rowCount = driver.findElements(By.xpath("//table[1]//tbody//tr")).size();
    Assert.assertEquals(rowCount, 3);
    Assert.assertTrue(driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']")).isEmpty());

    }
    /**
     * Let's write a function that will return column index based on column name
     */
    @Test
    public void getColumnIndexByName() {
        String columnName = "Email";
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));
        int index = 0;
        for (int i = 0; i < columnNames.size(); i++) {
            if (columnNames.get(i).getText().equals(columnName)) {
                index = i + 1;
            }
        }
        Assert.assertEquals(index, 3);
    }



    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(2);
        driver.quit();
    }
}