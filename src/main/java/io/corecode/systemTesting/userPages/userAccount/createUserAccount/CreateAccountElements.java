package io.corecode.systemTesting.userPages.userAccount.createUserAccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountElements {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(id="userName")
    protected WebElement userName;

    @FindBy(id="password")
    protected WebElement password;

    @FindBy(id="submitCreateAccount")
    protected WebElement submitCreateAccount;

    @FindBy(id="message")
    protected WebElement message;

}
