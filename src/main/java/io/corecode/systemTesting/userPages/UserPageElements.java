package io.corecode.systemTesting.userPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserPageElements {
    @FindBy(id="message")
    protected WebElement message;
    @FindBy(xpath="//a[contains(@id,'title')]")
    protected List<WebElement> bookLinks;
    @FindBy(id="myReviews")
    protected WebElement myReviews;
    @FindBy(id="updateMyInformation")
    protected WebElement updateMyInformation;
}
