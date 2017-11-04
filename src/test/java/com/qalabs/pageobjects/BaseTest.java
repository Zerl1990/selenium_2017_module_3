package com.qalabs.pageobjects;

import com.qalabs.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void beforeTest(String browser) {
        System.out.println("Getting webdriver instance");
        driver = WebDriverFactory.getDriver(browser);
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Killing webdriver instance");
        driver.quit();
    }
}
