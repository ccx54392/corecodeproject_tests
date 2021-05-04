package io.corecode.systemTesting.userPages.userAccount.updateUserAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class UpdateAccountActions extends UpdateAccountElements {

    public UpdateAccountActions(WebDriver driver, WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }

    public void writeUserName(String text){
        new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(By.id("userName")));
        JavascriptExecutor j = (JavascriptExecutor)driver;
        j.executeScript("arguments[0].value='"+text+"';",userName);
    }
    public void writePassword(String text){
        new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        JavascriptExecutor j = (JavascriptExecutor)driver;
        j.executeScript("arguments[0].value='"+text+"';",password);
    }
    public void clickSubmitUpdateAccount(){
        wait.until(ExpectedConditions.visibilityOf(this.submitUpdateInformation));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",this.submitUpdateInformation);
    }

    public String getMessage(){
        wait.until(ExpectedConditions.textMatches(By.id("message"), Pattern.compile("\\S")));
        return message.getText();
    }
}
