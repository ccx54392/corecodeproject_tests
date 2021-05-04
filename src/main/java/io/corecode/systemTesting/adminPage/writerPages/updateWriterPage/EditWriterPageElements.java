package io.corecode.systemTesting.adminPage.writerPages.updateWriterPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditWriterPageElements {
    @FindBy(id="name")
    protected WebElement name;
    @FindBy(id="submitUpdateWriter")
    protected WebElement submit;
    @FindBy(id="message")
    protected WebElement message;
}
