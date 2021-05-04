package io.corecode.systemTesting.homePage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageActions extends HomePageElements {
    private WebDriver driver;
    private WebDriverWait wait;
    public HomePageActions(WebDriver driver, WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }

    public void clickCreateAccount(){
        wait.until(ExpectedConditions.visibilityOf(this.createAccount));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", this.createAccount);
    }


}
