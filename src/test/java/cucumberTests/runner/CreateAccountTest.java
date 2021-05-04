package cucumberTests.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test(groups = {"bdd","createAccountBddTest"})
@CucumberOptions(
        features = {"src/test/resources/features/createAccount.feature"},
        glue = {"cucumberTests/tests", "cucumberTests/hooksAndSharedData"},
        plugin = {"pretty","html:target/cucumber-reports/cucumber-reports.html", "json:target/cucumber-reports/Cucumber.json"},
        publish = false
)
public class CreateAccountTest extends AbstractTestNGCucumberTests {
}
