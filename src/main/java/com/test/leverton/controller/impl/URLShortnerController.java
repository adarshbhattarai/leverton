package com.test.leverton.controller.impl;

import com.test.leverton.model.URL;
import com.test.leverton.service.URLShortnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by adarshbhattarai on 4/25/18.
 */
@RestController
@RequestMapping("/short-url")
public class URLShortnerController{

    @Autowired
    private URLShortnerService urlShortnerService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<URL>> getAllUrls(){

        List<URL> urlList = urlShortnerService.getAllURL();
        return new ResponseEntity<List<URL>> (urlList, HttpStatus.OK);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<String> getShortURL(@RequestParam("url") String longUrl){

        URL url = urlShortnerService.findByURL(longUrl);
        if(url == null){
            String shortUrl = urlShortnerService.createShortURL(longUrl);
            return new ResponseEntity<String> (shortUrl, HttpStatus.OK);
        }
        return new ResponseEntity<String>(url.getShortUrl(),HttpStatus.OK);
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public @ResponseBody URL addShortURL(@RequestBody URL url){

        URL addedURL = urlShortnerService.add(url);
        return addedURL;
    }


    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Void> removeArticleById(@RequestParam("url") String url){
        URL longurl = urlShortnerService.findByURL(url);
        if(longurl  == null ) {
            return new ResponseEntity<Void>( HttpStatus.NOT_FOUND);
        }
        urlShortnerService.remove(longurl);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
