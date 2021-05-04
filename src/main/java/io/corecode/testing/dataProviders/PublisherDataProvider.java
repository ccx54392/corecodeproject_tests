package io.corecode.testing.dataProviders;

import com.google.gson.Gson;
import io.corecode.testing.model.Publisher;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class PublisherDataProvider {

    private int limit = 2;
    private static List<Integer> publishersAdded = new ArrayList<Integer>();

    @DataProvider(name = "getPublishers")
    public Iterator<Object[]> getPublishers() {
        Collection<Object[]> data = new ArrayList<>();
        for (int i = 0; i < this.limit; i++){
            JSONObject bodyContent = new JSONObject();
            bodyContent.put("name","publisher qa test"+i);
            data.add(new Object[]{bodyContent.toString()});
        }
        return data.iterator();
    }
    @DataProvider(name = "getUpdatePublishers")
    public Iterator<Object[]> getUpdatePublishersAdded() {
        Collection<Object[]> data = new ArrayList<>();
        for (int i = 0; i < publishersAdded.size(); i++){
            JSONObject bodyContent = new JSONObject();
            bodyContent.put("name","publisher qa update test "+i);
            data.add(new Object[]{publishersAdded.get(i),bodyContent.toString()});
        }
        return data.iterator();
    }
    @DataProvider(name = "getPublishersAdded")
    public Iterator<Object[]> getPublishersAdded() {
        Collection<Object[]> data = new ArrayList<>();
        for (int i = 0; i < publishersAdded.size(); i++){
            data.add(new Object[]{publishersAdded.get(i)});
        }
        return data.iterator();
    }

    public static int addPublisher(Response response) {
        int id = new Gson().fromJson(response.asString(), Publisher.class).getPublisherId();
        publishersAdded.add(id);
        return id;
    }

}
