package com.qalabs.pageobjects;

import org.testng.annotations.*;
public class TestNGExample3_BTest {
    @BeforeSuite
    public void toExecuteBeforeSuite() {
        System.out.println("Before Suite - 3_B");
    }
    @AfterSuite
    public void toExecuteAfterSuite() {
        System.out.println("After Suite - 3_B");
    }
    @BeforeClass
    public void toExecuteBeforeClass() {
        System.out.println("Before Class - 3_B");
    }
    @AfterClass
    public void toExecuteAfterClass() {
        System.out.println("After Class - 3_B");
    }
    @BeforeTest
    public void toExecuteBeforeTest() {
        System.out.println("Before Test - 3_B");
    }
    @AfterTest
    public void toExecuteAfterTest() {
        System.out.println("After Test - 3_B");
    }
    @BeforeMethod
    public void toExecuteBeforeMethod() {
        System.out.println("Before Method - 3_B");
    }
    @AfterMethod
    public void toExecuteAfterMethod() {
        System.out.println("After Method - 3_B");
    }
    @Test
    public void test1() { System.out.println("TEST1 - 3_B"); }
    @Test
    public void test2() {
        System.out.println("TEST2 - 3_B");
    }
    @Test
    public void test3() {
        System.out.println("TEST3 - 3_B");
    }
}
