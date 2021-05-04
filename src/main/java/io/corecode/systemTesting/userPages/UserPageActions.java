package io.corecode.systemTesting.userPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class UserPageActions extends UserPageElements{
    private WebDriver driver;
    private WebDriverWait wait;
    public UserPageActions(WebDriver driver,WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }
    public String getMessage() {
        wait.until(ExpectedConditions.visibilityOf(this.message));
        //wait.until(ExpectedConditions.textMatches(By.id("message"), Pattern.compile("\\S")));
        return this.message.getText();
    }
    public void clickFirstBookLink(){
        wait.until(ExpectedConditions.visibilityOfAllElements(this.bookLinks));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", this.bookLinks.get(0));
        //this.bookLinks.get(0).click();
    }
    public void clickMyReviews(){
        wait.until(ExpectedConditions.visibilityOf(this.myReviews));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", this.myReviews);
    }
    public void clickChangeAccountInformation(){
        wait.until(ExpectedConditions.visibilityOf(this.updateMyInformation));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", this.updateMyInformation);
    }


}
