package cucumberTests.hooksAndSharedData;


import cucumberTests.driver.MyDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hooks {
    private SharedData sharedData;

    public Hooks(SharedData sharedData){
        this.sharedData=sharedData;
    }

    @Before
    public void initDriver(){
        MyDriver myDriver = new MyDriver();
        sharedData.driver = myDriver.openDriver("");
        sharedData.wait = new WebDriverWait(sharedData.driver, 15,100);
    }
    @After
    public void closeDriver(){
        sharedData.driver.quit();
    }
}
