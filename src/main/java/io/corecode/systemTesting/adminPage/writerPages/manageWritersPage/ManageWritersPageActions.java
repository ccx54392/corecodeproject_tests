package io.corecode.systemTesting.adminPage.writerPages.manageWritersPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class ManageWritersPageActions extends ManageWritersPageElements{
    private WebDriver driver;
    private WebDriverWait wait;
    public ManageWritersPageActions(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }
    public void clickCreateWriter(){
        this.createWriter.click();
    }

    public void clickLastEditLink(){
        wait.until(ExpectedConditions.visibilityOfAllElements(this.editLinks));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",this.editLinks.get(this.editLinks.size()-1));
    }

    public void clickLastDeleteLink(){
        wait.until(ExpectedConditions.visibilityOfAllElements(this.deleteLinks));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",this.deleteLinks.get(this.deleteLinks.size()-1));
    }

    public String getMessage(){
        wait.until(ExpectedConditions.textMatches(By.id("message"), Pattern.compile("\\S")));

        wait.until(ExpectedConditions.visibilityOf(this.message));
        return this.message.getText();
    }

}
