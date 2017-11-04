package com.qalabs.google;


import com.qalabs.common.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResultItem extends BaseElement{
    public ResultItem(WebElement element) {
        super(element);
    }

    private WebElement title() {
        return this.root.findElement(By.xpath("//h3[@class='r']"));
    }

    public String getDescription() {
        return this.root.getText();
    }

    public String getTitle() {
        return this.title().getText();
    }

    public void click() {
        logger.info("Clicking result: " + this.getTitle());
        this.title().click();
        logger.info(this.getTitle() + " clicked");
    }

    @Override
    public String toString() {
        return String.format("%s\n", this.getDescription());
    }
}
