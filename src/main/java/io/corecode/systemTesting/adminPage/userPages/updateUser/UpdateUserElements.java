package io.corecode.systemTesting.adminPage.userPages.updateUser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateUserElements {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "submitUpdateUser")
    WebElement submitUpdateUser;

    @FindBy(id = "message")
    WebElement message;


}
