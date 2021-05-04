package io.corecode.systemTesting.adminPage.publisherPages.createPublisher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class CreatePublisherActions  extends CreatePublisherElements{
    public CreatePublisherActions(WebDriver driver, WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }

    public void writeName(String text){
        wait.until(ExpectedConditions.visibilityOf(this.name));
        name.sendKeys(text);
    }

    public void clickSubmitCreatePublisher(){
        submitCreatePublisher.submit();
    }

    public String getMessage(){
        wait.until(ExpectedConditions.textMatches(By.id("message"), Pattern.compile("\\S")));

        return message.getText();
    }
}
