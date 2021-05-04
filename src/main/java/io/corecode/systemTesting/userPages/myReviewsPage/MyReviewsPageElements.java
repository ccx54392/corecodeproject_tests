package io.corecode.systemTesting.userPages.myReviewsPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyReviewsPageElements {
    @FindBy(xpath="//a[contains(@href,'updateReview')]")
    protected List<WebElement> updateLinks;
    @FindBy(xpath="//a[contains(@id,'delete')]")
    protected List<WebElement> deleteLinks;
    @FindBy(id="message")
    protected WebElement message;

}
