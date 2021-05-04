package io.corecode.systemTesting.adminPage.writerPages.manageWritersPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ManageWritersPageElements {
    @FindBy(id="createWriter")
    protected WebElement createWriter;
    @FindBy(xpath = "//a[contains(@id,'edit')]")
    protected List<WebElement> editLinks;
    @FindBy(xpath = "//a[contains(@id,'delete')]")
    protected List<WebElement> deleteLinks;
    @FindBy(id="message")
    protected WebElement message;
}
