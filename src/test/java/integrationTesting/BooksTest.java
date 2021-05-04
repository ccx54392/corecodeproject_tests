package integrationTesting;

import io.corecode.MyConstants;
import io.corecode.testing.dataProviders.BookDataProvider;
import io.corecode.testing.integrationTest.RequestTemplate;
import io.restassured.response.Response;
import org.testng.annotations.Test;


public class BooksTest {

    @Test(priority = 5, groups = {"integrationTest", "bookIntegrationTest"})
    public void getBooks() {
        RequestTemplate.getRequest(MyConstants.url + "book");
        System.out.println("[TEST PASSED] All books obtained successfully");
    }


    @Test(priority = 10, dataProviderClass = BookDataProvider.class, dataProvider = "addBookParameters", groups = {"integrationTest", "bookIntegrationTest"})
    public void addBook(String body) {
        Response response = RequestTemplate.postRequest(MyConstants.url + "book", body);
        System.out.println("[TEST PASSED] Book " + BookDataProvider.addBook(response) + " added successfully");
    }

    @Test(priority = 15, dataProviderClass = BookDataProvider.class, dataProvider = "deleteBookParameters", groups = {"integrationTest", "bookIntegrationTest"})
    public void getBookbyId(int id) {
        RequestTemplate.getRequest(MyConstants.url + "book/" + id);
        System.out.println("[TEST PASSED] Book " + id + " obtained successfully");
    }

    @Test(priority = 20, dataProviderClass = BookDataProvider.class, dataProvider = "updateBookParameters", groups = {"integrationTest", "bookIntegrationTest"})
    public void updateBook(String body, int id) {
        RequestTemplate.putRequest(MyConstants.url + "book/" + id, body);
        System.out.println("[TEST PASSED] Book " + id + " updated successfully");
    }

    @Test(priority = 25, dataProviderClass = BookDataProvider.class, dataProvider = "deleteBookParameters", groups = {"integrationTest", "bookIntegrationTest"})
    public void deleteBook(int id) {
        Response response = RequestTemplate.deleteRequest(MyConstants.url + "book/" + id);
        System.out.println("[TEST PASSED] Book " + id + " deleted successfully");
    }

}
