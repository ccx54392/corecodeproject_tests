package cucumberTests.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test(groups = {"bdd","loginBddTest"})
@CucumberOptions(
        features = {"src/test/resources/features/login.feature"},
        glue = {"cucumberTests/tests", "cucumberTests/hooksAndSharedData"},
        plugin = {"html:target/cucumber-reports/cucumber-reports.html", "json:target/cucumber-reports/Cucumber.json"},
        publish = false
)
public class LoginTest extends AbstractTestNGCucumberTests {
}
