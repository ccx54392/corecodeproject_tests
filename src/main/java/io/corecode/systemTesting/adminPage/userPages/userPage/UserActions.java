package io.corecode.systemTesting.adminPage.userPages.userPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class UserActions extends UserElements {

    public UserActions(WebDriver driver, WebDriverWait wait) {

        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }

    public void clickUpdate(){
        wait.until(ExpectedConditions.visibilityOfAllElements(this.updateLinks));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",updateLinks.get(updateLinks.size()-1));
    }

    public void clickDelete(){
        wait.until(ExpectedConditions.visibilityOfAllElements(this.deleteLinks));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",deleteLinks.get(deleteLinks.size()-1));
    }

    public String getMessage(){
        wait.until(ExpectedConditions.textMatches(By.id("message"), Pattern.compile("\\S")));
        return message.getText();
    }
}
