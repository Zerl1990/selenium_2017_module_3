package com.qalabs.facebook;

import com.qalabs.common.BasePage;
import com.qalabs.utils.PropertyReader;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lmrivas on 20/10/2017.
 */
public class FacebokLoginPage extends BasePage {
    @FindBy(how = How.ID, using = "email")
    WebElement emailTextBox;

    @FindBy(how = How.ID, using = "pass")
    WebElement passwordTextbox;

    @FindBy(how = How.XPATH, using = "//*[@data-testid='royal_login_button']")
    WebElement siginButton;

    public FacebokLoginPage(WebDriver driver)  {
        super(driver, PropertyReader.getProperty("endpoints.properties", "FACEBOOK_LOGIN_URL"));
    }

    public FacebookMainPage login(String email, String password) {
        this.emailTextBox.sendKeys(email);
        this.passwordTextbox.sendKeys(password);
        logger.info(String.format("Logging with %s - %s", email, password));
        this.siginButton.submit();
        logger.info("Logged!");
        return new FacebookMainPage(this.driver);
    }

    @Override
    public boolean isLoaded() {
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, 10);
            List<WebElement> elements = new ArrayList<WebElement>();
            elements.add(this.emailTextBox);
            elements.add(this.passwordTextbox);
            elements.add(this.siginButton);
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
            return true;
        } catch (TimeoutException exception) {
            logger.error(exception.toString());
            return false;
        }
    }
}
