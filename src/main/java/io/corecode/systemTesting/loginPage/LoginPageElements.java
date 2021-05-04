package io.corecode.systemTesting.loginPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageElements {
    @FindBy(id = "userName")
    protected WebElement userName;
    @FindBy(id = "password")
    protected WebElement password;
    @FindBy(id = "submitLogin")
    protected WebElement submitLogin;
    @FindBy(id="message")
    protected WebElement message;
}
