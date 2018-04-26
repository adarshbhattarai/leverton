package com.test.leverton.repository;

import com.test.leverton.model.URL;

import java.util.List;

/**
 * Created by adarshbhattarai on 4/25/18.
 */
public interface URLShortnerRepository {
    URL findByURL(String longUrl);

    void remove(URL url);

    URL add(URL url);

    List<URL> getAllURL();
}
