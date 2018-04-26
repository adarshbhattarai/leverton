package com.test.leverton.service;

import com.test.leverton.model.URL;

import java.util.List;

/**
 * Created by adarshbhattarai on 4/25/18.
 */
public interface URLShortnerService {
    URL findByURL(String longUrl);

    String createShortURL(String longUrl);

    List<URL> getAllURL();

    URL add(URL url);

    void remove(URL longurl);

}
