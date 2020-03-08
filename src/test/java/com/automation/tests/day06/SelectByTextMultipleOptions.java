package com.automation.tests.day06;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOptions {
    public static void main(String[] args) {


        WebDriver driver =  DriverFactory.createADriver(DriverFactory.Browser.Chrome);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        Select languageSelect = new Select(driver.findElement(By.name("Languages")));
        boolean isMultiple = languageSelect.isMultiple();
        System.out.println(isMultiple);  // if its true you can select more than one option.
        languageSelect.selectByVisibleText("Java");
        languageSelect.selectByVisibleText("JavaScript");
        languageSelect.selectByVisibleText("Python");

        List<WebElement> selectedLanguage = languageSelect.getAllSelectedOptions();

        selectedLanguage.forEach(language -> System.out.println(language.getText()));

        languageSelect.deselectByVisibleText("Java");   // To unselect Something
        BrowserUtils.wait(2);
        languageSelect.deselectAll();






        BrowserUtils.wait(3);
        driver.quit();
    }
}
