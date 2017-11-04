package com.qalabs.pageobjects;

import org.testng.annotations.*;

public class TestNGExample3_ATest {
    @BeforeSuite
    public void toExecuteBeforeSuite() {
        System.out.println("Before Suite - 3_A");
    }
    @AfterSuite
    public void toExecuteAfterSuite() {
        System.out.println("After Suite - 3_A");
    }
    @BeforeClass
    public void toExecuteBeforeClass() {
        System.out.println("Before Class - 3_A");
    }
    @AfterClass
    public void toExecuteAfterClass() {
        System.out.println("After Class - 3_A");
    }
    @BeforeTest
    public void toExecuteBeforeTest() {
        System.out.println("Before Test - 3_A");
    }
    @AfterTest
    public void toExecuteAfterTest() {
        System.out.println("After Test - 3_A");
    }
    @BeforeMethod
    public void toExecuteBeforeMethod() {
        System.out.println("Before Method - 3_A");
    }
    @AfterMethod
    public void toExecuteAfterMethod() {
        System.out.println("After Method - 3_A");
    }
    @Test
    public void test1() { System.out.println("TEST1 - 3_A"); }
    @Test
    public void test2() {
        System.out.println("TEST2 - 3_A");
    }
    @Test
    public void test3() {
        System.out.println("TEST3 - 3_A");
    }
}
