package io.corecode.systemTesting.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class LoginPagePageActions extends LoginPageElements {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPagePageActions(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    public void enterUserName(String username) {
        this.userName.sendKeys(username);
    }

    public void enterPassword(String username) {
        this.password.sendKeys(username);
    }

    public void clickSubmitLogin() {
        this.submitLogin.click();
    }

    public void loginUser(String userName, String password) {
        this.enterUserName(userName);
        this.enterPassword(password);
        this.clickSubmitLogin();
    }

    public String getMessage() {
        wait.until(ExpectedConditions.textMatches(By.id("message"), Pattern.compile("\\S")));
        return this.message.getText();
    }
}
