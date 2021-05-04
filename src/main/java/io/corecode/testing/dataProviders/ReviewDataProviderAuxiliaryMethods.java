package io.corecode.testing.dataProviders;

import com.google.gson.Gson;
import io.corecode.MyConstants;
import io.corecode.testing.integrationTest.RequestTemplate;
import io.corecode.testing.model.*;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ReviewDataProviderAuxiliaryMethods {


    protected static List<Review> reviewsAdded = new ArrayList<Review>();
    protected int limit = 2;

    public int addUser() {
        JSONObject bodyContent = new JSONObject();
        bodyContent.put("userName", "test user");
        bodyContent.put("password", "test password");
        bodyContent.put("role", "user");
        Response response = RequestTemplate.postRequest(MyConstants.url + "user/", bodyContent.toString());
        return new Gson().fromJson(response.asString(), User.class).getUserId();
    }

    private int addWriter() {
        JSONObject bodyContent = new JSONObject();
        bodyContent.put("name", "test writer");
        Response response = RequestTemplate.postRequest(MyConstants.url + "writer/", bodyContent.toString());
        return new Gson().fromJson(response.asString(), Writer.class).getWriterId();
    }

    private int addPublisher() {
        JSONObject bodyContent = new JSONObject();
        bodyContent.put("name", "test publisher");
        Response response = RequestTemplate.postRequest(MyConstants.url + "publisher/", bodyContent.toString());
        return new Gson().fromJson(response.asString(), Publisher.class).getPublisherId();
    }

    protected int addBook() {
        JSONObject bodyContent = new JSONObject();
        bodyContent.put("title", "test book");
        bodyContent.put("writerId", addWriter());
        bodyContent.put("publisherId", addPublisher());
        bodyContent.put("description", "test book");
        Response response = RequestTemplate.postRequest(MyConstants.url + "book/", bodyContent.toString());
        return new Gson().fromJson(response.asString(), Book.class).getBookId();
    }

    public static void deleteAuxiliaryEntities(){
        RequestTemplate.deleteRequest(MyConstants.url+"user/"+reviewsAdded.get(0).getUserId());
        for(Review review : reviewsAdded){
            RequestTemplate.deleteRequest(MyConstants.url+"publisher/"+review.getBook().getPublisherId());
            RequestTemplate.deleteRequest(MyConstants.url+"writer/"+review.getBook().getWriterId());
        }
    }



}
