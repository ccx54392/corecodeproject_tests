package io.corecode.systemTesting.adminPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPageElements {
    @FindBy(id = "message")
    protected WebElement message;
    @FindBy(id="manageWriters")
    protected WebElement manageWriters;
    @FindBy(id="manageBooks")
    protected WebElement manageBooks;
    @FindBy(id="manageReviews")
    protected WebElement manageReviews;
    @FindBy(id="manageUsers")
    protected WebElement manageUsers;
    @FindBy(id="managePublishers")
    protected WebElement managePublishers;


}
