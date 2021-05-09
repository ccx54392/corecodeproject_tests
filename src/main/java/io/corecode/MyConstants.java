package io.corecode;

public class MyConstants {
    /**
     * api
     */
    public static String url="https://corecodeqa-myapi.herokuapp.com/";
    //public static String url="http://localhost:8080/myapi/";
    //public static String url="http://localhost:8080/";


    /**
     * website
     */
    public static String website="https://corecodeqa-mywebsite.herokuapp.com/";
    //public static String website="http://localhost:8080/";

    static {
        String webUrl=System.getProperty("webUrl");
        if(webUrl!=null && !webUrl.equals("")){
            website=webUrl;
        }
        String apiUrl=System.getProperty("apiUrl");
        if(apiUrl!=null && !apiUrl.equals("")){
            url=apiUrl;
        }

    }
}
