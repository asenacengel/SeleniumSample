package com.automation.pages.fleet;


import com.automation.pages.LoginPage;

import com.automation.tests.vytrack.testBase;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewVehiclePageTests extends testBase {

    @Test
    public void verifyTitle(){
        LoginPage loginPage = new LoginPage();
        vehiclePage vehiclePage = new vehiclePage();

        loginPage.login();
        vehiclePage.navigateTo("Fleet", "Vehicles");

        String expectedTitle = "All - Car - Entities - System - Car - Entities - System";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
