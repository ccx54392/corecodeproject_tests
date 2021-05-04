package systemTesting;

import io.corecode.MyConstants;
import io.corecode.systemTesting.InitDriver;
import io.corecode.systemTesting.adminPage.AdminPageActions;
import io.corecode.systemTesting.adminPage.userPages.updateUser.UpdateUserActions;
import io.corecode.systemTesting.adminPage.userPages.userPage.UserActions;
import io.corecode.systemTesting.homePage.HomePageActions;
import io.corecode.systemTesting.loginPage.LoginPagePageActions;
import io.corecode.systemTesting.userPages.UserPageActions;
import io.corecode.systemTesting.userPages.userAccount.createUserAccount.CreateAccountActions;
import io.corecode.systemTesting.userPages.userAccount.updateUserAccount.UpdateAccountActions;
import io.corecode.systemTesting.userPages.userAccount.updateUserAccount.UpdateAccountElements;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserAccountTest extends InitDriver {

    private HomePageActions homePage;
    private CreateAccountActions createAccount;
    private UpdateAccountActions updateAccount;
    private LoginPagePageActions login;
    private UserPageActions userPage;
    private AdminPageActions adminPage;
    private UserActions userActions;
    private UpdateUserActions updateUserAdmin;

    @Test(priority = 100, groups = {"systemTest", "UserAccountTest"})
    public void createAccount(){
        driver.get(MyConstants.website);
        homePage=new HomePageActions(driver, wait);
        homePage.clickCreateAccount();
        createAccount= new CreateAccountActions(driver, wait);
        createAccount.writeUserName("QA System Test");
        createAccount.writePassword("QA");
        createAccount.clickSubmitCreateAccount();
        Assert.assertEquals(createAccount.getMessage(),"User was successfully created, you can now log in");
    }

    @Test(priority = 105, groups = {"systemTest", "UserAccountTest"})
    public void updateAccountUser(){
        driver.get(MyConstants.website + "login");
        login = new LoginPagePageActions(driver, wait);
        login.loginUser("QA System Test", "QA");
        userPage = new UserPageActions(driver, wait);
        userPage.clickChangeAccountInformation();
        updateAccount= new UpdateAccountActions(driver,wait);
        updateAccount.writeUserName("QA System Test Update");
        updateAccount.writePassword("QA");
        updateAccount.clickSubmitUpdateAccount();
        Assert.assertEquals(updateAccount.getMessage(),"User was updated successfully");
    }

    @Test(priority = 110, groups = {"systemTest", "UserAccountTest"})
    public void updateAccountAdmin(){
        driver.get(MyConstants.website + "login");
        login = new LoginPagePageActions(driver, wait);
        login.loginUser("admin", "admin");
        adminPage=new AdminPageActions(driver,wait);
        adminPage.clickManageUser();
        userActions= new UserActions(driver,wait);
        userActions.clickUpdate();
        updateUserAdmin = new UpdateUserActions(driver,wait);
        updateUserAdmin.writeUserName("QA System Test Update Admin");
        updateUserAdmin.writePassword("QA Admin");
        updateUserAdmin.clickSubmitUpdate();
        Assert.assertEquals(updateUserAdmin.getMessage(),"User was updated successfully");
    }

    @Test(priority = 115, groups = {"systemTest", "UserAccountTest"})
    public void deleteAccountAdmin(){
        driver.get(MyConstants.website + "login");
        login = new LoginPagePageActions(driver, wait);
        login.loginUser("admin", "admin");
        adminPage=new AdminPageActions(driver,wait);
        adminPage.clickManageUser();
        userActions= new UserActions(driver,wait);
        userActions.clickDelete();
        Assert.assertEquals(userActions.getMessage(),"User deleted successfully");
    }
}
