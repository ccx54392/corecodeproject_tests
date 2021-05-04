package systemTesting;

import io.corecode.MyConstants;
import io.corecode.systemTesting.InitDriver;
import io.corecode.systemTesting.adminPage.AdminPageActions;
import io.corecode.systemTesting.adminPage.bookPages.bookPages.BookPageActions;
import io.corecode.systemTesting.adminPage.bookPages.createBook.BookActions;
import io.corecode.systemTesting.adminPage.bookPages.updateBook.UpdateBookActions;
import io.corecode.systemTesting.loginPage.LoginPagePageActions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookSystemTest extends InitDriver {

    private AdminPageActions adminActions;
    private LoginPagePageActions loginActions;
    private BookActions bookActions;
    private BookPageActions pageActions;
    private UpdateBookActions updateActions;

    @Test(priority = 100, groups = {"systemTest", "bookSystemTest"})
    public void createBook() {
        driver.get(MyConstants.website + "login");
        loginActions = new LoginPagePageActions(driver, wait);
        loginActions.loginUser("admin", "admin");
        adminActions = new AdminPageActions(driver, wait);
        adminActions.clickManageBooks();
        pageActions = new BookPageActions(driver, wait);
        pageActions.clickCreateButton();
        bookActions = new BookActions(driver, wait);
        bookActions.writeTittle("Book QA");
        bookActions.writeDescription("Create Book for system testing");
        bookActions.writeCover("Cover example");
        bookActions.writePicture("Picture example");
        bookActions.clickSubmitCreate();
        Assert.assertEquals(bookActions.getMessage(), "Book was successfully created");
    }

    @Test(priority = 105, groups = {"systemTest", "bookSystemTest"})
    public void updateBook() {
        driver.get(MyConstants.website + "login");
        loginActions = new LoginPagePageActions(driver, wait);
        loginActions.loginUser("admin", "admin");
        adminActions = new AdminPageActions(driver, wait);
        adminActions.clickManageBooks();
        pageActions = new BookPageActions(driver, wait);
        pageActions.clickUpdateLink();
        updateActions = new UpdateBookActions(driver, wait);
        updateActions.writeTittle("Update QA");
        updateActions.writeDescription("Update Book for system testing");
        updateActions.writeCover("Cover example");
        updateActions.writePicture("Picture example");
        updateActions.clickSubmitUpdate();
        Assert.assertEquals(bookActions.getMessage(), "Book was updated successfully");

    }

    @Test(priority = 110, groups = {"systemTest", "bookSystemTest"})
    public void deleteBook() throws Exception{
        driver.get(MyConstants.website + "login");
        loginActions = new LoginPagePageActions(driver, wait);
        loginActions.loginUser("admin", "admin");
        adminActions = new AdminPageActions(driver, wait);
        adminActions.clickManageBooks();
        pageActions = new BookPageActions(driver, wait);
        pageActions.clickDeleteLink();
        Assert.assertEquals(pageActions.getMessage(), "Book deleted successfully");

    }
}
