package com.test.leverton.model;

/**
 * Created by adarshbhattarai on 4/25/18.
 */
public class URL {

    String longUrl;
    String shortUrl;

    public URL(String longUrl, String shortUrl){
        this.longUrl=longUrl;
        this.shortUrl=shortUrl;
    }
    public String getLongUrl() {
        return longUrl;
    }
    public String getShortUrl() {
        return shortUrl;
    }

}
