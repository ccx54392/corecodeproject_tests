package integrationTesting;

import io.corecode.MyConstants;
import io.corecode.testing.dataProviders.ReviewDataProvider;
import io.corecode.testing.integrationTest.RequestTemplate;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ReviewTest {

    private String path = "review/";

    @Test(priority = 100, dataProviderClass = ReviewDataProvider.class, dataProvider = "getReviews", groups = {"integrationTest", "reviewIntegrationTest"})
    public void createReview(String bodyContent) {
        Response response = RequestTemplate.postRequest(MyConstants.url + path, bodyContent);
        System.out.println("[TEST PASSED] Review " + ReviewDataProvider.addReview(response) + " added successfully");
    }

    @Test(priority = 200, groups = {"integrationTest", "reviewIntegrationTest"})
    public void getAll() {
        RequestTemplate.getRequest(MyConstants.url + path);
        System.out.println("[TEST PASSED] All reviews obtained successfully");
    }

    @Test(priority = 300, dataProviderClass = ReviewDataProvider.class, dataProvider = "getReviewsAdded", groups = {"integrationTest", "reviewIntegrationTest"})
    public void getReview(int id) {
        RequestTemplate.getRequest(MyConstants.url + path + id);
        System.out.println("[TEST PASSED] Review " + id + " obtained successfully");
    }

    @Test(priority = 400, dataProviderClass = ReviewDataProvider.class, dataProvider = "getUpdateReviews", groups = {"integrationTest", "reviewIntegrationTest"})
    public void updateReview(int id, String bodyContent) {
        RequestTemplate.putRequest(MyConstants.url + path + id, bodyContent);
        System.out.println("[TEST PASSED] Review " + id + " updated successfully");
    }

    @Test(priority = 500, dataProviderClass = ReviewDataProvider.class, dataProvider = "getReviewsAdded", groups = {"integrationTest", "reviewIntegrationTest"})
    public void deleteReview(int id) {
        RequestTemplate.deleteRequest(MyConstants.url + path + id);
        System.out.println("[TEST PASSED] Review " + id + " deleted successfully");
    }

    @AfterClass
    public void deleteAuxiliaryEntities() {
        ReviewDataProvider.deleteAuxiliaryEntities();
    }
}
