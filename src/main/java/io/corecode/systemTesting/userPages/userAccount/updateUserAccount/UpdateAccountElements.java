package io.corecode.systemTesting.userPages.userAccount.updateUserAccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateAccountElements {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(id="userName")
    protected WebElement userName;

    @FindBy(id="password")
    protected WebElement password;

    @FindBy(id="submitUpdateInformation")
    protected WebElement submitUpdateInformation;

    @FindBy(id="message")
    protected WebElement message;

}
