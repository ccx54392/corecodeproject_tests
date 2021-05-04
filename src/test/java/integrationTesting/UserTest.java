package integrationTesting;

import io.corecode.MyConstants;
import io.corecode.testing.dataProviders.UserDataProvider;
import io.corecode.testing.integrationTest.RequestTemplate;
import io.restassured.response.Response;
import org.testng.annotations.Test;


public class UserTest {

    @Test(priority = 5, groups = {"integrationTest", "userIntegrationTest"})
    public void getUsers() {
        RequestTemplate.getRequest(MyConstants.url + "user");
        System.out.println("[TEST PASSED] All users obtained successfully");
    }


    @Test(priority = 10, dataProviderClass = UserDataProvider.class, dataProvider = "addUsersParameters", groups = {"integrationTest", "userIntegrationTest"})
    public void addUser(String body) {
        Response response = RequestTemplate.postRequest(MyConstants.url + "user", body);
        System.out.println("[TEST PASSED] User " + UserDataProvider.addUser(response) + " added successfully");
    }

    @Test(priority = 15, dataProviderClass = UserDataProvider.class, dataProvider = "deleteUsersParameters", groups = {"integrationTest", "userIntegrationTest"})
    public void getUserbyId(int id) {
        RequestTemplate.getRequest(MyConstants.url + "user/" + id);
        System.out.println("[TEST PASSED] User " + id + " obtained successfully");
    }

    @Test(priority = 20, dataProviderClass = UserDataProvider.class, dataProvider = "updateUsersParameters", groups = {"integrationTest", "userIntegrationTest"})
    public void updateUser(String body, int id) {
        RequestTemplate.putRequest(MyConstants.url + "user/" + id, body);
        System.out.println("[TEST PASSED] User " + id + " updated successfully");
    }

    @Test(priority = 25, dataProviderClass = UserDataProvider.class, dataProvider = "deleteUsersParameters", groups = {"integrationTest", "userIntegrationTest"})
    public void deleteUser(int id) {
        Response response = RequestTemplate.deleteRequest(MyConstants.url + "user/" + id);
        System.out.println("[TEST PASSED] User " + id + " deleted successfully");
    }

}
