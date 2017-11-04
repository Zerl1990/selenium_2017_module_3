package com.qalabs.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.Assert;

import java.util.List;


public class TestNGExample4Test extends BaseTest {
    @Test(description = "Open google page", alwaysRun = true, groups = {"regression"})
    @Parameters("baseUrl")
    public void openGoogle(String baseUrl) {
        driver.get(baseUrl);
        Assert.assertEquals(baseUrl, driver.getCurrentUrl(), "Didn't get expected google url");
    }

    @Test(description = "Search selenium in google search box",
            dependsOnMethods = {"openGoogle"}, groups = {"regression"})
    public void searchSelenium() {
        WebElement searchBox = driver.findElement(By.id("lst-ib"));
        searchBox.sendKeys("Selenium");
        searchBox.sendKeys(Keys.ENTER);
        List<WebElement> results = driver.findElements(By.xpath("//*[@class='rc']"));
        Assert.assertTrue(results.size() > 0, "Didn't get any result");
    }
}

