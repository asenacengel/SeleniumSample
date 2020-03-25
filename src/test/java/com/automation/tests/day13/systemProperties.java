package com.automation.tests.day13;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class systemProperties {

    @Test
    public void test(){
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("os.name"));
        String pathToDownloads = System.getProperty("user.home")+"/Downloads";
        System.out.println(pathToDownloads);
        System.out.println(System.getProperty("os.arch"));

    }
}
