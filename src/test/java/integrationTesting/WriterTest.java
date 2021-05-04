package integrationTesting;

import io.corecode.MyConstants;
import io.corecode.testing.dataProviders.WriterDataProvider;
import io.corecode.testing.integrationTest.RequestTemplate;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class WriterTest {

    private String path = "writer/";

    @Test(priority = 100, dataProviderClass = WriterDataProvider.class, dataProvider = "getWriters",groups={"integrationTest","writerIntegrationTest"})
    public void createWriter(String bodyContent) {
        Response response = RequestTemplate.postRequest(MyConstants.url+path, bodyContent);
        System.out.println("[TEST PASSED] Writer " + WriterDataProvider.addWriter(response) + " added successfully");
    }

    @Test(priority = 200,groups={"integrationTest","writerIntegrationTest"})
    public void getAll() {
        RequestTemplate.getRequest(MyConstants.url+path);
        System.out.println("[TEST PASSED] All writers obtained successfully");
    }

    @Test(priority = 300, dataProviderClass = WriterDataProvider.class, dataProvider = "getWritersAdded",groups={"integrationTest","writerIntegrationTest"})
    public void getWriter(int id) {
        RequestTemplate.getRequest(MyConstants.url+path + id);
        System.out.println("[TEST PASSED] Writer " + id + " obtained successfully");
    }

    @Test(priority = 400, dataProviderClass = WriterDataProvider.class, dataProvider = "getUpdateWriters",groups={"integrationTest","writerIntegrationTest"})
    public void updateWriter(int id, String bodyContent) {
        RequestTemplate.putRequest(MyConstants.url+path + id, bodyContent);
        System.out.println("[TEST PASSED] Writer " + id + " updated successfully");
    }

    @Test(priority = 500, dataProviderClass = WriterDataProvider.class, dataProvider = "getWritersAdded",groups={"integrationTest","writerIntegrationTest"})
    public void deleteWriter(int id) {
        RequestTemplate.deleteRequest(MyConstants.url+path+ id);
        System.out.println("[TEST PASSED] Writer " + id + " deleted successfully");
    }
}
