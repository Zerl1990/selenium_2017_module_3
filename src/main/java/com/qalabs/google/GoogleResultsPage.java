package com.qalabs.google;

import com.qalabs.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class GoogleResultsPage extends BasePage {

    @FindBy(how = How.ID, using = "lst-ib")
    private WebElement searchBox;

    @FindBy(how = How.NAME, using = "btnG")
    private WebElement searchButton;

    @FindBy(how = How.XPATH, using = "//*[@class='srg']//*[@class='g']")
    private List<WebElement> results;

    @FindBy(how = How.ID, using = "pnnext")
    private WebElement nextButton;

    @FindBy(how = How.ID, using = "pnprev")
    private WebElement prevButton;

    public GoogleResultsPage(WebDriver driver) {
       super(driver, driver.getCurrentUrl());
    }

    public GoogleResultsPage search(String searchTxt) {
        logger.info("Searching: " + searchTxt);
        this.searchBox.clear();
        this.searchBox.sendKeys(searchTxt);
        this.searchButton.click();
        logger.info("Searched: " + searchTxt);
        logger.info("Returning google result page object");
        return new GoogleResultsPage(this.driver);
    }

    public String currentSearch() {
        String currentSearch = this.searchBox.getAttribute("value");
        logger.info("Current search: " + currentSearch);
        return currentSearch;
    }

    public List<ResultItem> getResults() {
        logger.info("Getting search results...");
        List<ResultItem> resultItems = new ArrayList<ResultItem>();
        for(WebElement result : results) {
            resultItems.add(new ResultItem(result));
        }
        logger.info(resultItems.toString());
        return resultItems;
    }

    public void nextResultPage() {
        logger.info("Clicking next button");
        nextButton.click();
        logger.info("Next button clicked!");
    }

    public void prevResultPage() {
        logger.info("Clicking prev button");
        prevButton.click();
        logger.info("Prev button clicked");
    }

    @Override
    public boolean isLoaded() {
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, 10);
            wait.until(ExpectedConditions.visibilityOfAllElements(results));
            logger.info("Google result page loaded");
            return true;
        } catch (RuntimeException exception) {
            logger.error("Google result page not loaded: " + exception);
            return false;
        }
    }
}
