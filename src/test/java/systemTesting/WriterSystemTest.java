package systemTesting;

import io.corecode.systemTesting.InitDriver;
import io.corecode.systemTesting.adminPage.AdminPageActions;
import io.corecode.systemTesting.loginPage.LoginPagePageActions;
import io.corecode.systemTesting.adminPage.writerPages.createWriterPage.CreateWriterPageActions;
import io.corecode.systemTesting.adminPage.writerPages.manageWritersPage.ManageWritersPageActions;
import io.corecode.systemTesting.adminPage.writerPages.updateWriterPage.EditWriterPageActions;
import io.corecode.MyConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WriterSystemTest extends InitDriver {
    private LoginPagePageActions login;
    private AdminPageActions adminPage;
    private ManageWritersPageActions manageWriters;
    private CreateWriterPageActions createWriter;
    private EditWriterPageActions editWriter;

    @Test(priority = 100,groups={"systemTest","writerSystemTest"})
    public void createWriter() {
        driver.get(MyConstants.website + "login");
        login = new LoginPagePageActions(driver, wait);
        login.loginUser("admin", "admin");
        adminPage = new AdminPageActions(driver, wait);
        String msg = adminPage.getMessage();
        Assert.assertEquals(msg, "User logged in successfully","User does not exist or credentials are wrong");
        adminPage.clickManageWriters();
        manageWriters = new ManageWritersPageActions(driver, wait);
        manageWriters.clickCreateWriter();
        createWriter = new CreateWriterPageActions(driver, wait);
        createWriter.enterWriterName("test qa");
        createWriter.clickSubmitCreateWriter();
        String message = createWriter.getMessage();
        Assert.assertEquals(message, "Writer was successfully created");
        System.out.println("[TEST PASSED] "+ message);

    }

    @Test(priority = 150,groups={"systemTest","writerSystemTest"})
    public void createEmptyWriter() {
        driver.get(MyConstants.website+"manageWriters");
        manageWriters = new ManageWritersPageActions(driver, wait);
        manageWriters.clickCreateWriter();
        createWriter = new CreateWriterPageActions(driver, wait);
        createWriter.enterWriterName("");
        createWriter.clickSubmitCreateWriter();
        String message = createWriter.getMessage();
        Assert.assertEquals(message, "Writer name can not be empty");
        System.out.println("[TEST PASSED] "+ message);

    }

    @Test(priority = 200, dependsOnMethods = {"createWriter"},groups={"systemTest","writerSystemTest"})
    public void updateWriter(){
        driver.get(MyConstants.website+"manageWriters");
        manageWriters = new ManageWritersPageActions(driver, wait);
        manageWriters.clickLastEditLink();
        editWriter = new EditWriterPageActions(driver,wait);
        editWriter.enterName("test qa updated");
        editWriter.submit();
        String message = editWriter.getMessage();
        Assert.assertEquals(message,"Writer was updated successfully");
        System.out.println("[TEST PASSED] "+ message);
    }

    @Test(priority = 300, dependsOnMethods = {"createWriter"},groups={"systemTest","writerSystemTest"})
    public void deleteWriter() {
        driver.get(MyConstants.website + "manageWriters");
        manageWriters = new ManageWritersPageActions(driver, wait);
        manageWriters.clickLastDeleteLink();
        String message = manageWriters.getMessage();
        Assert.assertEquals(message, "Writer was deleted successfully");
        System.out.println("[TEST PASSED] "+ message);

    }
}
