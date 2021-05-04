package io.corecode.systemTesting.adminPage.manageReviewsPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ManageReviewsPageElements {
    @FindBy(xpath="//a[contains(@id,'delete')]")
    List<WebElement> deleteLinks;
    @FindBy(id="message")
    WebElement message;
}
