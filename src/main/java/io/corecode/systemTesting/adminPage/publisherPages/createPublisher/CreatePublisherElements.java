package io.corecode.systemTesting.adminPage.publisherPages.createPublisher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatePublisherElements {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "submitCreatePublisher")
    WebElement submitCreatePublisher;

    @FindBy(id = "name")
    WebElement name;

    @FindBy(id = "message")
    WebElement message;
}
