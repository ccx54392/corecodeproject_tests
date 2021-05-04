package systemTesting;

import io.corecode.MyConstants;
import io.corecode.systemTesting.InitDriver;
import io.corecode.systemTesting.adminPage.AdminPageActions;
import io.corecode.systemTesting.commonPageActions.LogInAsUser;
import io.corecode.systemTesting.dataProviders.ReviewDataProvider;
import io.corecode.systemTesting.loginPage.LoginPagePageActions;
import io.corecode.systemTesting.adminPage.manageReviewsPage.ManageReviewsPageActions;
import io.corecode.systemTesting.userPages.UserPageActions;
import io.corecode.systemTesting.userPages.addReviewPage.AddReviewPageActions;
import io.corecode.systemTesting.userPages.myReviewsPage.MyReviewsPageActions;
import io.corecode.systemTesting.userPages.updateReviewPage.UpdateReviewPageActions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReviewSystemTest extends InitDriver {
    private LoginPagePageActions login;
    private UserPageActions userPage;
    private AddReviewPageActions addReview;
    private UpdateReviewPageActions updateReview;
    private MyReviewsPageActions myReviews;
    private AdminPageActions adminPage;
    private ManageReviewsPageActions manageReviews;

    @Test(priority=100, dataProvider = "getReviews", dataProviderClass = ReviewDataProvider.class,groups={"systemTest","reviewSystemTest"})
    public void createReview(String reviewDescription){
        userPage = new LogInAsUser(driver,wait).logRegularUser("user","user");
        userPage.clickFirstBookLink();
        addReview = new AddReviewPageActions(driver,wait);
        String message = addReview.addReview(4,reviewDescription);
        Assert.assertEquals(message,"Your review was successfully added");
        System.out.println("[TEST PASSED] "+message);
    }

    @Test(priority=150,groups={"systemTest","reviewSystemTest"})
    public void createEmptyReview(){
        userPage = new LogInAsUser(driver,wait).logRegularUser("user","user");
        userPage.clickFirstBookLink();
        System.out.println("[DEBUG] clicked on first book");
        addReview = new AddReviewPageActions(driver,wait);
        String message = addReview.addReview(3,"");
        System.out.println("[DEBUG] enter stars, description and get message");
        Assert.assertEquals(message,"Review description can not be empty");
        System.out.println("[TEST PASSED] "+message);
    }

    @Test(priority=200,groups={"systemTest","reviewSystemTest"})
    public void updateReviewBookPage(){
        userPage = new LogInAsUser(driver,wait).logRegularUser("user","user");
        userPage.clickFirstBookLink();
        addReview = new AddReviewPageActions(driver,wait);
        addReview.clickLastUpdateLink();
        updateReview = new UpdateReviewPageActions(driver,wait);
        String message = updateReview.updateReview(3,"test qa update 0");
        Assert.assertEquals(message,"Review was updated successfully");
        System.out.println("[TEST PASSED] "+message);
    }
    @Test(priority=200,groups={"systemTest","reviewSystemTest"})
    public void updateReviewMyReviewsPage(){
        userPage = new LogInAsUser(driver,wait).logRegularUser("user","user");
        userPage.clickMyReviews();
        myReviews = new MyReviewsPageActions(driver,wait);
        myReviews.clickLastUpdateLink();
        updateReview = new UpdateReviewPageActions(driver,wait);
        String message = updateReview.updateReview(4,"test qa update 1");
        Assert.assertEquals(message,"Review was updated successfully");
        System.out.println("[TEST PASSED] "+message);
    }

    @Test(priority = 300,groups={"systemTest","reviewSystemTest"})
    public void deleteReviewBookPage(){
        userPage = new LogInAsUser(driver,wait).logRegularUser("user","user");
        userPage.clickFirstBookLink();
        addReview = new AddReviewPageActions(driver,wait);
        addReview.clickLastDeleteLink();
        String message = addReview.getMessage();
        Assert.assertEquals(message,"Review was deleted successfully");
        System.out.println("[TEST PASSED] "+message);
    }


    @Test(priority = 300,groups={"systemTest","reviewSystemTest"})
    public void deleteReviewMyReviewsPage(){
        userPage = new LogInAsUser(driver,wait).logRegularUser("user","user");
        userPage.clickMyReviews();
        myReviews = new MyReviewsPageActions(driver,wait);
        myReviews.clickLastDeleteLink();
        String message = myReviews.getMessage();
        Assert.assertEquals(message,"Review was deleted successfully");
        System.out.println("[TEST PASSED] "+message);
    }

    @Test(priority = 350,groups={"systemTest","reviewSystemTest"})
    public void deleteReviewAdminPage(){
        driver.get(MyConstants.website+"manageWriters");
        adminPage = new AdminPageActions(driver,wait);
        adminPage.clickManageReviews();
        manageReviews = new ManageReviewsPageActions(driver,wait);
        manageReviews.clickLastDeleteLink();
        String message = manageReviews.getMessage();
        Assert.assertEquals(message,"Review was deleted successfully");
        System.out.println("[TEST PASSED] "+message);
    }

}
