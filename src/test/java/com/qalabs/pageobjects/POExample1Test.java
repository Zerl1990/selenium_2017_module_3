package com.qalabs.pageobjects;


import com.qalabs.google.GoogleMainPage;
import com.qalabs.google.GoogleResultsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class POExample1Test extends BaseTest{
    private GoogleMainPage google;
    private GoogleResultsPage resultsPage;

    @BeforeClass
    public void initializeGooglePage() {
        this.google = new GoogleMainPage(this.driver);
        this.resultsPage = null;
    }

    @Test
    public void openGoogle() {
        google.open();
        Assert.assertTrue(google.isLoaded());
    }

    @Test (description = "Search something in google", dependsOnMethods = {"openGoogle"})
    public void searchInGoogle() {
        String searchTxt = "Selenium";
        this.resultsPage = google.searchInGoogle(searchTxt);
        Assert.assertTrue(this.resultsPage.isLoaded(), "Page not loaded");
        Assert.assertEquals(searchTxt, this.resultsPage.currentSearch());
        Assert.assertTrue(this.resultsPage.getResults().size() > 0, "No results!");
    }

    @Test(description = "Search something again", dependsOnMethods = {"searchInGoogle"})
    public void performNewSearch() {
        String searchTxt = "Java";
        this.resultsPage = this.resultsPage.search(searchTxt);
        Assert.assertTrue(this.resultsPage.isLoaded(), "Page not loaded");
        Assert.assertEquals(searchTxt, this.resultsPage.currentSearch());
        Assert.assertTrue(this.resultsPage.getResults().size() > 0, "No results!");
    }

    @Test(description = "Click next button", dependsOnMethods = {"performNewSearch"})
    public void clickNextResults() {
        this.resultsPage.nextResultPage();
        Assert.assertTrue(this.resultsPage.isLoaded(), "Page not loaded");
        Assert.assertTrue(this.resultsPage.getResults().size() > 0, "No results!");
    }

    @Test(description = "Click prev button", dependsOnMethods = {"clickNextResults"})
    public void clickPrevResults() {
        this.resultsPage.prevResultPage();
        Assert.assertTrue(this.resultsPage.isLoaded(), "Page not loaded");
        Assert.assertTrue(this.resultsPage.getResults().size() > 0, "No results!");
    }

    @Test(description = "Select first result found", dependsOnMethods = {"clickPrevResults"})
    public void selectFirstResult() {
        String title = this.resultsPage.getResults().get(0).getTitle();
        String description = this.resultsPage.getResults().get(0).getDescription();
        Assert.assertNotNull(title, "Title is null");
        Assert.assertNotNull(description, "Description is null");
        this.resultsPage.getResults().get(0).click();
    }
}
