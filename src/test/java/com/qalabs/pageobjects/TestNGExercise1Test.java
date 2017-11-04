package com.qalabs.pageobjects;

import com.qalabs.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGExercise1Test {
    @Test
    public void test() {
        String url = "https://www.google.com/";
        WebDriver driver = WebDriverFactory.getDriver("Firefox");
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.close();
    }
}
