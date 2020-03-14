package com.automation.tests.day09;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {

    // runs only once before @BeforeClass and @BeforeMethod
    @BeforeTest
    public void beforeTest(){
        System.out.println("BEFORE TEST");
    }

    // Runs only once after @Afterclass aand @Aftermethod
    @AfterTest
    public void afterTest(){
        System.out.println("AFTER TEST");
    }


    // Runs only once in the class before @beforemethod and before any test
    // regardless on number of tests, it runs only once

    @BeforeClass
    public void beforeClass(){
        System.out.println("BEFORE CLASS");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("AFTER CLASS");
    }
    // RUNS BEFORE EVERY TEST AUTOMATICALLY
    // works as a pre-condition or set-up
    @BeforeMethod
    public void setUp(){
        System.out.printf("BEFORE METHOD");
    }

    @AfterMethod
    public void tearDown(){
        System.out.printf("AFTER METHOD");
    }

    @Test
    public void test1(){
        System.out.println("TEST 1 ");
        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void  test2(){
        System.out.printf("TEST 2 ");
        int num1 = 5;
        int num2 = 10;
        // it calls hard assertion.
        // if assertion fails - it stops the execution (due to exception).
        Assert.assertTrue(num1<num2 );
    }
}
