package io.corecode;

public class MyConstants {
    /**
     * api
     */
    public static String url="http://myapi-env.eba-3me5caza.us-east-2.elasticbeanstalk.com/";
    //public static String url="http://localhost:8080/myapi/";
    //public static String url="http://localhost:8080/";


    /**
     * website
     */
    public static String website="http://mywebsite2-env.eba-yihsxqmu.us-east-2.elasticbeanstalk.com/";
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
