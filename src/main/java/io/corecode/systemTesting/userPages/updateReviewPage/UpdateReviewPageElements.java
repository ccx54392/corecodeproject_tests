package io.corecode.systemTesting.userPages.updateReviewPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateReviewPageElements {
    @FindBy(id="stars")
    protected WebElement reviewStars;
    @FindBy(id="description")
    protected WebElement reviewDescription;
    @FindBy(id="submitUpdateReview")
    protected WebElement submitUpdateReview;
    @FindBy(id="message")
    protected WebElement message;

}
