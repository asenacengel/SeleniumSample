package com.automation.tests.day05;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) {

        WebDriver driver =  DriverFactory.createADriver(DriverFactory.Browser.Chrome);
        driver.get("http://practice.cybertekschool.com/checkboxes");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        checkBoxes.get(0).click();   // click on the first check box
        BrowserUtils.wait(2);
        for (int i = 0; i < checkBoxes.size(); i++) {


            if (checkBoxes.get(1).isDisplayed() && checkBoxes.get(1).isEnabled() && (!checkBoxes.get(1).isSelected())) {
                checkBoxes.get(i).click();  // click on the second box
            }else {
                System.out.println(i+1 + " checkbox wasn't clicked ");
            }
        }

        BrowserUtils.wait(2);
        driver.quit();

    }
}
