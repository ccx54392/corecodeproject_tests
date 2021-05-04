package io.corecode.systemTesting.adminPage.writerPages.createWriterPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateWriterPageElements {
    @FindBy(id = "name")
    protected WebElement name;
    @FindBy(id = "submitCreateWriter")
    protected WebElement submitCreateWriter;
    @FindBy(id = "message")
    protected WebElement message;

}
