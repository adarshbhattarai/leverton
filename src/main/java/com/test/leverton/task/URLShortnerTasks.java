package com.test.leverton.task;

import java.net.URL;

/**
 * Created by adarshbhattarai on 4/25/18.
 */
public class URLShortnerTasks {


    //Considering The URLS are all valid.
    public static boolean validate(String longUrl) {
        try{
            new URL(longUrl).toURI();
            return true;
        }catch (Exception e){

        }
        return  false;
    }

    /*
    * The Idea to shorten a url is to First
    * remove the protocols.
    * */
    public static String getShortURL(String longUrl) {

        //remove http:// or https://

        //Suppose we have https://google.com , https://leverton.ai
        //we want to keep it as google.com or leverton.ai
        //Also We can hash the key using SHA256 algorithm,
        //and generate a unique key for every URL's
        //But I believe that is out of scope of this task.
        longUrl = longUrl.replaceAll("^.*[://]","");
        //Apply some operations of longURL
        //longUrl = uniqueKeySHAAlgo(longURL)
        return longUrl;

    }
}
