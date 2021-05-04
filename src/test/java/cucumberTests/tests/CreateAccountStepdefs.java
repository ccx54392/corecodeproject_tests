package cucumberTests.tests;

import cucumberTests.hooksAndSharedData.SharedData;
import io.corecode.MyConstants;
import io.corecode.systemTesting.userPages.userAccount.createUserAccount.CreateAccountActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreateAccountStepdefs {
    private SharedData sharedData;
    private CreateAccountActions createAccount;

    public CreateAccountStepdefs(SharedData sharedData) {
        this.sharedData = sharedData;
        createAccount = new CreateAccountActions(sharedData.driver, sharedData.wait);
    }

    @Given("that we create a new account on {string}")
    public void thatWeCreateANewAccountOn(String path) {
        sharedData.driver.get(MyConstants.website+path);

    }

    @And("we click on the create account button")
    public void weClickOnTheCreateAccountButton() {
        createAccount.clickSubmitCreateAccount();
    }
}
