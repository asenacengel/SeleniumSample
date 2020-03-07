package com.automation.tests.day05;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxesTest {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver(DriverFactory.Browser.Chrome);
        driver.get("http://practice.cybertekschool.com/checkboxes");
        driver.manage().window().maximize();

        // TASK
        // verify that check box is not selected and 2 ic selected

        List<WebElement>  checkBoxes = driver.findElements(By.tagName("input"));

        for (int i = 0; i < checkBoxes.size(); i++) {
            checkBoxes.get(i+1).isSelected();
        }

        boolean isSelected = checkBoxes.get(1).isSelected();
        System.out.println(isSelected);
        BrowserUtils.wait(2);
        driver.quit();

    }
}
