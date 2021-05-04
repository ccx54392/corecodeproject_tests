package io.corecode.systemTesting.userPages.addReviewPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class AddReviewPageActions extends AddReviewPageElements{
    private WebDriver driver;
    private WebDriverWait wait;

    public AddReviewPageActions(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    public void enterReviewDescription(String description){
        wait.until(ExpectedConditions.visibilityOf(this.reviewDescription));
        wait.until(ExpectedConditions.elementToBeClickable(this.reviewDescription));
        this.reviewDescription.sendKeys(description);
    }

    public void clickSubmitReviewButton(){
        wait.until(ExpectedConditions.elementToBeClickable(this.submitReview));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", this.submitReview);
    }

    public String getMessage(){
        wait.until(ExpectedConditions.textMatches(By.id("message"), Pattern.compile("\\S")));

        return this.message.getText();
    }

    public void setReviewStars(int stars){
        /*
        wait.until(ExpectedConditions.visibilityOf(this.reviewStars));
        Select starsReview = new Select(this.reviewStars);
        starsReview.selectByValue(String.valueOf(stars));
        */
    }

    public void clickLastUpdateLink(){
        wait.until(ExpectedConditions.visibilityOfAllElements(this.updateLinks));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", this.updateLinks.get(this.updateLinks.size()-1));
    }

    public void clickLastDeleteLink(){
        wait.until(ExpectedConditions.visibilityOfAllElements(this.deleteLinks));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", this.deleteLinks.get(this.deleteLinks.size()-1));
    }

    public String addReview(int stars,String reviewDescription){
        this.setReviewStars(stars);
        this.enterReviewDescription(reviewDescription);
        this.clickSubmitReviewButton();
        return this.getMessage();
    }
}
