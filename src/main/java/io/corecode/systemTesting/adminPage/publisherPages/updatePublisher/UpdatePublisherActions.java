package io.corecode.systemTesting.adminPage.publisherPages.updatePublisher;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class UpdatePublisherActions extends UpdatePublisherElements {

    public UpdatePublisherActions(WebDriver driver, WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }

    public void writeName(String text){
        new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
        JavascriptExecutor j = (JavascriptExecutor)driver;
        j.executeScript("arguments[0].value='"+text+"';",name);
    }

    public void clickSubmitUpdate(){
        submitUpdatePublisher.submit();
    }

    public String getMessage(){
        wait.until(ExpectedConditions.textMatches(By.id("message"), Pattern.compile("\\S")));

        return message.getText();
    }
}
