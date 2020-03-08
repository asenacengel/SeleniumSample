package com.automation.tests.day06;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectBytext {
    public static void main(String[] args) {

        WebDriver driver =  DriverFactory.createADriver(DriverFactory.Browser.Chrome);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        // Create a webElement object for drop-down first
       WebElement simpleDropDown = driver.findElement(By.id("dropdown"));

       // provide webElement object into constructor
        Select selectSimpleDropDown = new Select(simpleDropDown);

        //Selecy by visible text
        selectSimpleDropDown.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);
        selectSimpleDropDown.selectByVisibleText("Option 1");

        Select yearDropDown = new Select(driver.findElement(By.id("year")));
        Select monthsDropDown = new Select(driver.findElement(By.id("month")));
        Select dayDropDown = new Select(driver.findElement(By.id("day")));

        yearDropDown.selectByVisibleText("1988");
        monthsDropDown.selectByVisibleText("February");
        dayDropDown.selectByVisibleText("1");

        //select all months one by one

        List<WebElement> months = monthsDropDown.getOptions();
        months.forEach(allmonths ->{
            monthsDropDown.selectByVisibleText(allmonths.getText());
            BrowserUtils.wait(1);
        });

        Select selectState = new Select(driver.findElement(By.id("state")));
        selectState.selectByVisibleText("District Of Columbia");

        String selected = selectState.getFirstSelectedOption().getText();
        if(selected.equals("District Of Columbia")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        List<WebElement> states = selectState.getOptions();
        states.forEach(eachState -> System.out.println(eachState.getText()));






        BrowserUtils.wait(3);
        driver.quit();
    }
}
