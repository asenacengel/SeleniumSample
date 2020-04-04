package com.automation.pages;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "prependedInput")
    public WebElement username;

    @FindBy(id = "prependedInput2")
    public WebElement password;

    @FindBy(id = "_submit")
    public WebElement login;

    @FindBy(linkText = "Forgot your password")
    private WebElement forgotPassword;

    @FindBy(css = "[class='alert alert-error']")
    private WebElement warningMessage;






    public LoginPage(){

        // to connect our webDriver page class and page factory
        //pageFactory - used to use @FindBy annotations
        //pageFactory - helps to find elements easier

        PageFactory.initElements(Driver.getDriver(), this);

    }
    public String getWarningMessageText(){
        return warningMessage.getText();
    }
    public void login(String username,String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password, Keys.ENTER);

    }
    // Method to login ,Version #2
    public void login(){
        username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(3);

    }



}
