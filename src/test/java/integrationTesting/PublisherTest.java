package integrationTesting;


import io.corecode.MyConstants;
import io.corecode.testing.dataProviders.PublisherDataProvider;
import io.corecode.testing.integrationTest.RequestTemplate;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class PublisherTest {

    private String path = "publisher/";

    @Test(priority = 100, dataProviderClass = PublisherDataProvider.class, dataProvider = "getPublishers", groups = {"integrationTest", "publisherIntegrationTest"})
    public void createPublisher(String bodyContent) {
        Response response = RequestTemplate.postRequest(MyConstants.url + path, bodyContent);
        System.out.println("[TEST PASSED] Publisher " + PublisherDataProvider.addPublisher(response) + " added successfully");
    }

    @Test(priority = 200, groups = {"integrationTest", "publisherIntegrationTest"})
    public void getAll() {
        RequestTemplate.getRequest(MyConstants.url + path);
        System.out.println("[TEST PASSED] All publishers obtained successfully");
    }

    @Test(priority = 300, dataProviderClass = PublisherDataProvider.class, dataProvider = "getPublishersAdded", groups = {"integrationTest", "publisherIntegrationTest"})
    public void getPublisher(int id) {
        RequestTemplate.getRequest(MyConstants.url + path + id);
        System.out.println("[TEST PASSED] Publisher " + id + " obtained successfully");
    }

    @Test(priority = 400, dataProviderClass = PublisherDataProvider.class, dataProvider = "getUpdatePublishers", groups = {"integrationTest", "publisherIntegrationTest"})
    public void updatePublisher(int id, String bodyContent) {
        RequestTemplate.putRequest(MyConstants.url + path + id, bodyContent);
        System.out.println("[TEST PASSED] Publisher " + id + " updated successfully");
    }

    @Test(priority = 500, dataProviderClass = PublisherDataProvider.class, dataProvider = "getPublishersAdded", groups = {"integrationTest", "publisherIntegrationTest"})
    public void deletePublisher(int id) {
        RequestTemplate.deleteRequest(MyConstants.url + path + id);
        System.out.println("[TEST PASSED] Publisher " + id + " deleted successfully");
    }
}
