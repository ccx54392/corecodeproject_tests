package io.corecode.testing.dataProviders;

import com.google.gson.Gson;
import io.corecode.testing.model.Review;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ReviewDataProvider extends ReviewDataProviderAuxiliaryMethods {

    @DataProvider(name = "getReviews")
    public Iterator<Object[]> getReviews() {
        Collection<Object[]> data = new ArrayList<>();
        int userId = addUser();
        for (int i = 0; i < limit; i++) {
            JSONObject bodyContent = new JSONObject();
            bodyContent.put("userId", userId);
            bodyContent.put("bookId", addBook());
            bodyContent.put("stars", 5);
            bodyContent.put("description", "review qa test" + i);
            data.add(new Object[]{bodyContent.toString()});
        }
        return data.iterator();
    }

    @DataProvider(name = "getUpdateReviews")
    public Iterator<Object[]> getUpdateReviewsAdded() {
        Collection<Object[]> data = new ArrayList<>();
        for (int i = 0; i < reviewsAdded.size(); i++) {
            JSONObject bodyContent = new JSONObject();
            bodyContent.put("userId", reviewsAdded.get(i).getUserId());
            bodyContent.put("bookId", reviewsAdded.get(i).getBookId());
            bodyContent.put("stars", 4);
            bodyContent.put("description", "review qa test updated" + i);
            data.add(new Object[]{reviewsAdded.get(i).getReviewId(), bodyContent.toString()});
        }
        return data.iterator();
    }

    @DataProvider(name = "getReviewsAdded")
    public Iterator<Object[]> getReviewsAdded() {
        Collection<Object[]> data = new ArrayList<>();
        for (int i = 0; i < reviewsAdded.size(); i++) {
            data.add(new Object[]{reviewsAdded.get(i).getReviewId()});
        }
        return data.iterator();
    }

    public static int addReview(Response response) {
        Review review = new Gson().fromJson(response.asString(), Review.class);
        reviewsAdded.add(review);
        return review.getReviewId();
    }

}
