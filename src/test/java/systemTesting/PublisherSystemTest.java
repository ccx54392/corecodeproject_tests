package systemTesting;

import io.corecode.MyConstants;
import io.corecode.systemTesting.InitDriver;
import io.corecode.systemTesting.adminPage.AdminPageActions;
import io.corecode.systemTesting.adminPage.publisherPages.createPublisher.CreatePublisherActions;
import io.corecode.systemTesting.adminPage.publisherPages.publisherPage.PublisherActions;
import io.corecode.systemTesting.adminPage.publisherPages.updatePublisher.UpdatePublisherActions;
import io.corecode.systemTesting.loginPage.LoginPagePageActions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PublisherSystemTest extends InitDriver {

    private AdminPageActions adminActions;
    private LoginPagePageActions loginActions;
    private PublisherActions pageActions;
    private CreatePublisherActions createActions;
    private UpdatePublisherActions updateActions;

    @Test(priority = 100, groups = {"systemTest", "PublisherSystemTest"})
    public void createPublisher(){
        driver.get(MyConstants.website + "login");
        loginActions= new LoginPagePageActions(driver,wait);
        loginActions.loginUser("admin","admin");
        adminActions= new AdminPageActions(driver,wait);
        adminActions.clickManagePublisher();
        pageActions=new PublisherActions(driver,wait);
        pageActions.clickCreateButton();
        createActions=new CreatePublisherActions(driver,wait);
        createActions.writeName("QA System Testing");
        createActions.clickSubmitCreatePublisher();
        Assert.assertEquals(createActions.getMessage(),"Publisher was successfully created");

    }

    @Test(priority = 110, groups = {"systemTest", "PublisherSystemTest"})
    public void updatePublisher(){
        driver.get(MyConstants.website + "login");
        loginActions= new LoginPagePageActions(driver,wait);
        loginActions.loginUser("admin","admin");
        adminActions= new AdminPageActions(driver,wait);
        adminActions.clickManagePublisher();
        pageActions=new PublisherActions(driver,wait);
        pageActions.clickUpdate();
        updateActions=new UpdatePublisherActions(driver,wait);
        updateActions.writeName("QA update publisher System test");
        updateActions.clickSubmitUpdate();
        Assert.assertEquals(updateActions.getMessage(),"Publisher was updated successfully");

    }

    @Test(priority = 120, groups = {"systemTest", "PublisherSystemTest"})
    public void deletePublisher(){
        driver.get(MyConstants.website + "login");
        loginActions= new LoginPagePageActions(driver,wait);
        loginActions.loginUser("admin","admin");
        adminActions= new AdminPageActions(driver,wait);
        adminActions.clickManagePublisher();
        pageActions=new PublisherActions(driver,wait);
        pageActions.clickDelete();
        Assert.assertEquals(pageActions.getMessage(),"Publisher deleted successfully");
    }
}
