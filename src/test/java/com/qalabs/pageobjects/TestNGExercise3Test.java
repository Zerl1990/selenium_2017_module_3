package com.qalabs.pageobjects;

import com.qalabs.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGExercise3Test extends BaseTest {
    @Test
    public void test() {
        String url = "https://www.google.com/";
        this.driver.get(url);
        Assert.assertEquals(this.driver.getCurrentUrl(), url);
    }
}
