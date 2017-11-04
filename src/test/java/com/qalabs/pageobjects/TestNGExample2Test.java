package com.qalabs.pageobjects;

import org.testng.annotations.Test;
import org.testng.Assert;

public class TestNGExample2Test {
    @Test(description = "Test 1", enabled = true, groups = {"Example2"})
    public void test1() {
        System.out.println("Test 1");
    }
    @Test(description = "Test 2", enabled = true, groups = {"Example2"})
    public void test2() {
        System.out.println("Test 2");
        Assert.assertEquals("Something", "Otherthing", "Error!");
    }
    @Test(description = "Test 3", enabled = true,
            dependsOnMethods = {"test2"},
            alwaysRun = true, groups = {"Example3"})
    public void test3() {
        System.out.println("Test 3");
    }
}
