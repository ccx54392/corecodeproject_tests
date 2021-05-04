package io.corecode.systemTesting.userPages.addReviewPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddReviewPageElements {
    @FindBy(xpath = "//*[@id='enterDescription']")
    protected WebElement reviewDescription;
    @FindBy(id="submitReview")
    protected WebElement submitReview;
    @FindBy(id="message")
    protected WebElement message;
    @FindBy(id="stars")
    protected WebElement reviewStars;
    @FindBy(xpath="//a[contains(@href,'updateReview')]")
    protected List<WebElement> updateLinks;
    @FindBy(xpath="//a[contains(@id,'delete')]")
    protected List<WebElement> deleteLinks;
}
