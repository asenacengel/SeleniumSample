package com.automation.tests.day09;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {
    public static void main(String[] args) {
        String expected ="cba";
        String toReverse = "abc";
        String actual = reverseString(toReverse);
        verifyEquals(expected, actual);


    }
    @Test(description = "Verify if method can reverse a string")
    public void test(){
        String expected = "elppa";
        String actual = reverseString("apple");
        //it coming from testng, junit also has this class
        // you can compare any data types here: strings,primitives,arrays,object
        // To verify if expected result is equals to actual.
        Assert.assertEquals(actual, expected);

    }
    @Test
    public void test2(){
        String expected = "rac";
        String actual = reverseString("car");
        Assert.assertEquals(actual, expected);

    }

    public static boolean verifyEquals(String expected,String actual){

        if(expected.equals(actual)){
            System.out.printf("Test Passed");
            return true;
        }else {
            System.out.printf("Test Failed");
            System.out.printf("Expected: "+expected);
            System.out.printf("Actual: "+actual);
            return false;
        }
    }

    public static String reverseString(String str){
        String reversed = "";
        for (int i = str.length()-1; i>= 0 ; i--) {
            reversed+=str.charAt(i);
        }
        return reversed;
    }
}
