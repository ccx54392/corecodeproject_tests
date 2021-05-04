package io.corecode.systemTesting.adminPage.userPages.updateUser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class UpdateUserActions extends UpdateUserElements {

    public UpdateUserActions(WebDriver driver, WebDriverWait wait) {
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

    public void clickSubmitUpdate(){
        submitUpdateUser.submit();
    }

    public String getMessage(){
        wait.until(ExpectedConditions.textMatches(By.id("message"), Pattern.compile("\\S")));
        return message.getText();
    }
}
