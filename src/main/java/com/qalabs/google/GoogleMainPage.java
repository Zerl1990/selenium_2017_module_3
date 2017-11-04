package com.qalabs.google;

import com.qalabs.common.BasePage;
import com.qalabs.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GoogleMainPage extends BasePage {
    @FindBy(how = How.ID, using = "lst-ib")
    private WebElement searchBox;

    @FindBy(how = How.NAME, using = "btnK")
    private WebElement searchInGoogleButton;

    @FindBy(how = How.NAME, using = "btnI")
    private WebElement feelingLuckyButton;

    @FindBy(how = How.ID, using = "hplogo")
    private WebElement doddle;

    public GoogleMainPage(WebDriver driver)  {
        super(driver, PropertyReader.getProperty("endpoints.properties", "GOOGLE_URL"));
    }

    public GoogleResultsPage searchInGoogle(String searchTxt) {
        logger.info("Searching in google: " + searchTxt);
        this.searchBox.clear();
        this.searchBox.sendKeys(searchTxt);
        this.searchInGoogleButton.submit();
        logger.info("Searched: " + searchTxt);
        logger.info("Returning google result page object");
        return new GoogleResultsPage(this.driver);
    }

    public GoogleResultsPage feelingLuckySearch(String searchTxt) {
        logger.info("Searching using feeling lucky: " + searchTxt);
        this.searchBox.clear();
        this.searchBox.sendKeys(searchTxt);
        this.feelingLuckyButton.submit();
        logger.info("Searched: " + searchTxt);
        logger.info("Returning google result page object");
        return new GoogleResultsPage(this.driver);
    }

    @Override
    public boolean isLoaded() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(doddle));
            logger.info("Google main page loaded");
            return true;
        } catch (RuntimeException exception) {
            logger.error("Google main page was not loaded: " + exception);
            return false;
        }
    }
}
