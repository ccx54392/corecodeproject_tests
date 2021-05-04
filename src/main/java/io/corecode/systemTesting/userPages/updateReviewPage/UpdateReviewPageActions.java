package io.corecode.systemTesting.userPages.updateReviewPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class UpdateReviewPageActions extends UpdateReviewPageElements{
    private WebDriver driver;
    private WebDriverWait wait;
    public UpdateReviewPageActions(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }
    public void setStars(int stars){
        /*
        wait.until(ExpectedConditions.visibilityOf(this.reviewStars));
        Select starsReview = new Select(this.reviewStars);
        starsReview.selectByValue(String.valueOf(stars));
        */
    }

    public void enterDescription(String description){
        wait.until(ExpectedConditions.visibilityOf(this.reviewDescription));
        this.reviewDescription.clear();
        this.reviewDescription.sendKeys("description");
    }
    public void clickSubmitUpdateReview(){
        wait.until(ExpectedConditions.visibilityOf(this.submitUpdateReview));
        this.submitUpdateReview.click();
    }
    public String getMessage() {
        wait.until(ExpectedConditions.textMatches(By.id("message"), Pattern.compile("\\S")));

        return this.message.getText();
    }

    public String updateReview(int stars,String reviewDescription){
        this.setStars(stars);
        this.enterDescription(reviewDescription);
        this.clickSubmitUpdateReview();
        return this.getMessage();
    }
}
