package io.corecode.systemTesting.adminPage.bookPages.bookPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BookPageElements {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(xpath = "//a[text()='Create Book']")
    WebElement createBookButton;

    @FindBy(xpath = "//a[contains(@id,'update')]")
    protected List<WebElement> updateLinks;

    @FindBy(xpath = "//a[contains(@id,'delete')]")
    protected List<WebElement> deleteLinks;

    @FindBy(id="message")
    protected WebElement message;

}
