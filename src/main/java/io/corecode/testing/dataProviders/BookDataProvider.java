package io.corecode.testing.dataProviders;
import com.google.gson.Gson;
import io.corecode.testing.model.Book;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BookDataProvider {

    private static List<Integer> booksAdded = new ArrayList<Integer>();
    private int limit=1;

    @DataProvider(name = "addBookParameters")
    public Iterator<Object[]> addBookParameters() {
        Collection<Object[]> data = new ArrayList<>();
        for (int i = 0; i < limit; i++){
            JSONObject bodyContent = new JSONObject();
            bodyContent.put("title","dataQA"+i);
            bodyContent.put("writerId", 1);
            bodyContent.put("cover","cover"+i);
            bodyContent.put("picture","picture"+i);
            bodyContent.put("publisherId",1);
            bodyContent.put("description","Book using for integation test"+i);
            data.add(new Object[]{bodyContent.toString()});
        }
        return data.iterator();
    }

    @DataProvider(name = "updateBookParameters")
    public Iterator<Object[]> updateBookParameters() throws Exception {
        Collection<Object[]> data = new ArrayList<>();
        for (int i = 0; i < booksAdded.size(); i++){
                JSONObject bodyUpdate = new JSONObject();
                bodyUpdate.put("title","dataQAupdate"+i);
                bodyUpdate.put("writerId", 2);
                bodyUpdate.put("cover","cover");
                bodyUpdate.put("picture","picture");
                bodyUpdate.put("publisherId",2);
                bodyUpdate.put("description","Book update for integation test");
                data.add(new Object[]{bodyUpdate.toString(),booksAdded.get(i)});
        }
        return data.iterator();
    }

    @DataProvider(name = "deleteBookParameters")
    public Iterator<Object[]> deleteBookParameters() throws Exception {
        Collection<Object[]> data = new ArrayList<>();
        for (int i = 0; i < booksAdded.size(); i++){
                data.add(new Object[]{booksAdded.get(i)});
        }
        return data.iterator();
    }

    public static int addBook(Response response) {
        int id = new Gson().fromJson(response.asString(), Book.class).getBookId();
        booksAdded.add(id);
        return id;
    }


}
