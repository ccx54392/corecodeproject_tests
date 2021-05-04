package io.corecode.systemTesting.adminPage.bookPages.updateBook;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class UpdateBookActions extends BookElementsUpdate {

    public UpdateBookActions(WebDriver driver, WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);

    }

    public void writeTittle(String text){
        new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(By.id("title")));
        JavascriptExecutor j = (JavascriptExecutor)driver;
        j.executeScript("arguments[0].value='"+text+"';",title);
    }

    public void writeDescription(String text){
        new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(By.id("description")));
        JavascriptExecutor j = (JavascriptExecutor)driver;
        j.executeScript("arguments[0].value='"+text+"';",description);
    }

    public void writeCover(String text){
        new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(By.id("cover")));
        JavascriptExecutor j = (JavascriptExecutor)driver;
        j.executeScript("arguments[0].value='"+text+"';",cover);
    }

    public void writePicture(String text){
        new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(By.id("picture")));
        JavascriptExecutor j = (JavascriptExecutor)driver;
        j.executeScript("arguments[0].value='"+text+"';",picture);
    }

    public void clickSubmitUpdate(){
        submitUpdateBook.submit();
    }

    public String getMessage(){
        wait.until(ExpectedConditions.textMatches(By.id("message"), Pattern.compile("\\S")));

        return message.getText();
    }
}
