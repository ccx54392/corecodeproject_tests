package io.corecode.systemTesting.adminPage.writerPages.updateWriterPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class EditWriterPageActions extends EditWriterPageElements{
    private WebDriver driver;
    private WebDriverWait wait;
    public EditWriterPageActions(WebDriver driver,WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }
    public String getMessage(){
        wait.until(ExpectedConditions.textMatches(By.id("message"), Pattern.compile("\\S")));

        //new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
        wait.until(ExpectedConditions.visibilityOf(this.message));
        return this.message.getText();
    }
    public void enterName(String name){
        //new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
        wait.until(ExpectedConditions.visibilityOf(this.name));
        JavascriptExecutor j = (JavascriptExecutor)driver;
        j.executeScript("arguments[0].value='"+name+"';", this.name);
    }
    public void submit(){
        //new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(By.id("submitUpdateWriter")));
        wait.until(ExpectedConditions.visibilityOf(this.submit));
        JavascriptExecutor j = (JavascriptExecutor)driver;
        j.executeScript("arguments[0].click();", this.submit);
    }
}
