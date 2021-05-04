package io.corecode.systemTesting.adminPage.userPages.userPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class UserElements {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "message")
    WebElement message;

    @FindBy(xpath = "//a[contains(@id,'edit')]")
    protected List<WebElement> updateLinks;

    @FindBy(xpath = "//a[contains(@id,'delete')]")
    protected List<WebElement> deleteLinks;

}
