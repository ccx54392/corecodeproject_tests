package io.corecode.testing.dataProviders;

import com.google.gson.Gson;
import io.corecode.testing.model.Book;
import io.corecode.testing.model.User;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class UserDataProvider {

    private static List<Integer> usersAdded = new ArrayList<Integer>();
    private int limit=1;

    @DataProvider(name = "addUsersParameters")
    public Iterator<Object[]> addUsersParameters() {
        Collection<Object[]> data = new ArrayList<>();
        for (int i = 0; i < limit; i++){
            JSONObject bodyContent = new JSONObject();
            bodyContent.put("userName","dataQA"+i);
            bodyContent.put("password", "pass123"+i);
            bodyContent.put("role", "user");
            data.add(new Object[]{bodyContent.toString()});
        }
        return data.iterator();
    }

    @DataProvider(name = "updateUsersParameters")
    public Iterator<Object[]> updateUsersParameters() throws Exception {
        Collection<Object[]> data = new ArrayList<>();
        for (int i = 0; i < usersAdded.size(); i++){
                JSONObject bodyUpdate = new JSONObject();
                bodyUpdate.put("userName","dataQAupdate"+i);
                bodyUpdate.put("password", "pass456"+i);
                bodyUpdate.put("role","user");
                data.add(new Object[]{bodyUpdate.toString(),usersAdded.get(i)});
        }
        return data.iterator();
    }

    @DataProvider(name = "deleteUsersParameters")
    public Iterator<Object[]> deleteUsersParameters() throws Exception {
        Collection<Object[]> data = new ArrayList<>();
        for (int i = 0; i < usersAdded.size(); i++){
                data.add(new Object[]{usersAdded.get(i)});
        }
        return data.iterator();
    }

    public static int addUser(Response response) {
        int id = new Gson().fromJson(response.asString(), User.class).getUserId();
        usersAdded.add(id);
        return id;
    }


}
