package cucumberTests.tests;

import cucumberTests.hooksAndSharedData.SharedData;
import io.corecode.MyConstants;
import io.corecode.systemTesting.loginPage.LoginPagePageActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginStepdefs {
    private SharedData sharedData;
    private LoginPagePageActions loginPage;

    public LoginStepdefs(SharedData sharedData){
        this.sharedData=sharedData;
        loginPage = new LoginPagePageActions(sharedData.driver, sharedData.wait);
    }

    @Given("that we try to log in at {string}")
    public void thatWeTryToLogInAt(String path) {
        sharedData.driver.get(MyConstants.website+path);
    }

    @When("we add the user name as {string}")
    public void weAddTheUserNameAs(String username) {
        loginPage.enterUserName(username);
    }

    @And("we add the password as {string}")
    public void weAddThePasswordAs(String password) {
        loginPage.enterPassword(password);
    }

    @Then("the page should show the message {string}")
    public void thePageShouldShowTheMessage(String message) {
        Assert.assertEquals(loginPage.getMessage(),message,"Message is wrong");
    }

    @And("we click on the login button")
    public void weClickOnTheLoginButton() {
        loginPage.clickSubmitLogin();
    }
}
