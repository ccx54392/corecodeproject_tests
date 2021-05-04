package io.corecode.systemTesting.commonPageActions;

import io.corecode.MyConstants;
import io.corecode.systemTesting.loginPage.LoginPagePageActions;
import io.corecode.systemTesting.userPages.UserPageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LogInAsUser {
    private LoginPagePageActions login;
    private UserPageActions userPage;
    private WebDriver driver;
    private WebDriverWait wait;

    public LogInAsUser(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public UserPageActions logRegularUser(String userName, String password){
        driver.get(MyConstants.website + "login");
        login = new LoginPagePageActions(driver,wait);
        login.loginUser(userName,password);
        userPage=new UserPageActions(driver,wait);
        Assert.assertEquals(userPage.getMessage(),"User logged in successfully","User does not exist or credentials are wrong");
        return userPage;
    }
}
