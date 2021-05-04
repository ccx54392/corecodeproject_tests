package io.corecode.systemTesting.dataProviders;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ReviewDataProvider {
    private int limit=3;
    @DataProvider(name="getReviews")
    public Iterator<Object[]> getReviews(){
        Collection<Object[]> data = new ArrayList<>();
        for(int i=0;i<this.limit;i++){
            data.add (new Object[]{"review qa "+i});
        }
        return data.iterator();
    }
}
