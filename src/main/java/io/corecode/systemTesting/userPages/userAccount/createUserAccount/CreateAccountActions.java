package io.corecode.systemTesting.userPages.userAccount.createUserAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class CreateAccountActions extends CreateAccountElements {

    public CreateAccountActions(WebDriver driver, WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }

    public void writeUserName(String text){
        wait.until(ExpectedConditions.visibilityOf(this.userName));
        userName.sendKeys(text);
    }


    public void writePassword(String text){
        wait.until(ExpectedConditions.visibilityOf(this.password));
        password.sendKeys(text);
    }

    public void clickSubmitCreateAccount(){
        wait.until(ExpectedConditions.visibilityOf(this.submitCreateAccount));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",this.submitCreateAccount);
        //submitCreateAccount.submit();
    }

    public String getMessage(){
        wait.until(ExpectedConditions.textMatches(By.id("message"),Pattern.compile("\\S")));
        return message.getText();
    }
}
