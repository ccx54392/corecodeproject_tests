package io.corecode.systemTesting.adminPage.bookPages.createBook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class BookActions extends BookElements {

    public BookActions(WebDriver driver, WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);

    }

    public void writeTittle(String text){
        title.sendKeys(text);
    }

    public void writeDescription(String text){
        description.sendKeys(text);
    }

    public void writeCover(String text){
        cover.sendKeys(text);
    }

    public void writePicture(String text){
        picture.sendKeys(text);
    }

    public void clickSubmitCreate(){
        submitCreateBook.submit();
    }

    public String getMessage(){
        wait.until(ExpectedConditions.textMatches(By.id("message"), Pattern.compile("\\S")));

        return message.getText();
    }
}
