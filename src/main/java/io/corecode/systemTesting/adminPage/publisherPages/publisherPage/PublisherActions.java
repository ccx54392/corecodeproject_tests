package io.corecode.systemTesting.adminPage.publisherPages.publisherPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class PublisherActions extends PublisherElements{

    public PublisherActions(WebDriver driver, WebDriverWait wait) {

        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }

    public void clickCreateButton(){
        wait.until(ExpectedConditions.visibilityOfAllElements(this.createButton));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",createButton);
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
