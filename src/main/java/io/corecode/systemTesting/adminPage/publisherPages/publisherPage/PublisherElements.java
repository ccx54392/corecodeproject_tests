package io.corecode.systemTesting.adminPage.publisherPages.publisherPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PublisherElements {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//a[text()='Create Publisher']")
    WebElement createButton;

    @FindBy(id = "message")
    WebElement message;

    @FindBy(xpath = "//a[contains(@id,'edit')]")
    protected List<WebElement> updateLinks;

    @FindBy(xpath = "//a[contains(@id,'delete')]")
    protected List<WebElement> deleteLinks;

}
