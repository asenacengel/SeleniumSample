package com.automation.pages;

import com.automation.tests.vytrack.testBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewLoginTests extends testBase {

    @Test(groups = "smoke")
    public void verifyPageTitle(){
        test = report.createTest("Verify page title");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        test.info("Login as store Manager");
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
        test.pass("Page title Dashboard was verified");
        BrowserUtils.getScreenShot("PageTitle");


    }
    @Test
    public void verifyWarningMessage(){
        test = report.createTest("Verify warning message");

        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong", "wrong");
        BrowserUtils.wait(3);
        Assert.assertEquals(loginPage.getWarningMessageText(),"Invalid user name or password.");

        BrowserUtils.getScreenShot("warning_message");
        test.pass("Warning message is displayed");


    }
    @Test(dataProvider = "credentials")
    public void loginWithDDT(String userName,String password){
        test = report.createTest("Verify page title");
        LoginPage loginPage = new LoginPage();
        loginPage.login(userName,password);
        BrowserUtils.wait(3);
        test.info("Login as " + userName);//log some steps
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
        test.pass("Page title Dashboard was verified");


    }
    @DataProvider
    public Object[][] credentials(){
        return new Object[][]{
                {"storemanager85","UserUser123"},
                {"salesmanager110","UserUser123"},
                {"user16","UserUser123"}
        };
    }


}
