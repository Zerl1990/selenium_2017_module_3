package com.qalabs.facebook;

import com.qalabs.common.BasePage;
import com.qalabs.utils.PropertyReader;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lmrivas on 20/10/2017.
 */
public class FacebookMainPage extends BasePage {
    @FindBy(how = How.NAME, using = "q")
    WebElement searchBox;

    @FindBy(how = How.XPATH, using = "//*[@title='Profile']")
    WebElement profileButton;

    @FindBy(how = How.XPATH, using = "//*[@data-referrer='timeline_light_nav_top']//*[@data-tab-key='timeline']")
    WebElement timelineButton;

    @FindBy(how = How.XPATH, using = "//*[@data-referrer='timeline_light_nav_top']//*[@data-tab-key='about']")
    WebElement aboutButton;

    @FindBy(how = How.XPATH, using = "//*[@data-referrer='timeline_light_nav_top']//*[@data-tab-key='friends']")
    WebElement friendsButton;

    @FindBy(how = How.XPATH, using = "//*[@data-referrer='timeline_light_nav_top']//*[@data-tab-key='photos']")
    WebElement photoButton;


    public FacebookMainPage(WebDriver driver)  {
        super(driver, PropertyReader.getProperty("endpoints.properties", "FACEBOOK_LOGIN_URL"));
    }

    public void clickProfile() {
        logger.info("Clicking profile photo");
        this.profileButton.click();
    }

    public void clickTimeline() {
        logger.info("Clicking timelineButton");
        this.timelineButton.click();
    }

    public void clickAbout() {
        logger.info("Clicking aboutButton");
        this.aboutButton.click();
    }

    public void clickFriends() {
        logger.info("Clicking friendsButton");
        this.friendsButton.click();
    }

    public void clickPhoto() {
        logger.info("Clicking photoButton");
        this.photoButton.click();
    }

    public void searchFriend(String friendName) {
        logger.info("Searching friend: " + friendName);
        this.searchBox.sendKeys(friendName);
        this.searchBox.submit();
    }

    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    public boolean isLoaded() {
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, 10);
            List<WebElement> elements = new ArrayList<WebElement>();
            elements.add(this.profileButton);
            elements.add(this.searchBox);
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
            return true;
        } catch (TimeoutException exception) {
            logger.error(exception.toString());
            return false;
        }
    }
}
