package com.test.leverton.service.impl;

import com.test.leverton.model.URL;
import com.test.leverton.repository.URLShortnerRepository;
import com.test.leverton.service.URLShortnerService;
import com.test.leverton.task.URLShortnerTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by adarshbhattarai on 4/25/18.
 */
@Service
public class URLShortnerServiceImpl implements URLShortnerService {
    @Autowired
    URLShortnerRepository urlShortnerRepository;

    @Override
    public URL findByURL(String longUrl) {

        URL url = urlShortnerRepository.findByURL(longUrl);
        return url;
    }

    @Override
    public String createShortURL(String longUrl) {

        boolean isUrlValid = URLShortnerTasks.validate(longUrl);

        String shortUrl = isUrlValid ? URLShortnerTasks.getShortURL(longUrl) : "Cannot Create Short Url" ;
        if(isUrlValid) {
            //If the given URL is valid, also add it to DB
            urlShortnerRepository.add(new URL(longUrl,shortUrl));
        }
        return shortUrl;
    }

    @Override
    public List<URL> getAllURL() {

        return urlShortnerRepository.getAllURL();
    }

    @Override
    public URL add(URL url) {
        return urlShortnerRepository.add(url);
    }

    @Override
    public void remove(URL url) {
        urlShortnerRepository.remove(url);
    }
}
