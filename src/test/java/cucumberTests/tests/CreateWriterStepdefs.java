package cucumberTests.tests;

import cucumberTests.hooksAndSharedData.SharedData;
import io.corecode.MyConstants;
import io.corecode.systemTesting.adminPage.writerPages.createWriterPage.CreateWriterPageActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CreateWriterStepdefs {
    private SharedData sharedData;
    private CreateWriterPageActions createWriter;

    public CreateWriterStepdefs(SharedData sharedData) {
        this.sharedData = sharedData;
        this.createWriter = new CreateWriterPageActions(this.sharedData.driver, this.sharedData.wait);
    }

    @Given("that we create a writer on {string}")
    public void thatWeCreateAWriterOn(String path) {
        this.sharedData.driver.get(MyConstants.website+path);
    }

    @When("we add the writer name as {string}")
    public void weAddTheWriterNameAs(String name) {
        this.createWriter.enterWriterName(name);
    }

    @And("we click on the create writer button")
    public void weClickOnTheCreateWriterButton() {
        this.createWriter.clickSubmitCreateWriter();
    }
}
