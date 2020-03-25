package com.automation.tests.day13;

import com.automation.utilities.Driver;
import com.automation.utilities.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class driverTest {


    @Test
    public void googleTest(){
        //Driver.getDriver() ---> returns driver
        Driver.getDriver().get("http://google.com");
        Assert.assertEquals(Driver.getDriver().getTitle(), "Google");
        Driver.closeDriver();
    }
}

