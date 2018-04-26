package com.test.leverton.repository.impl;

import com.test.leverton.model.URL;
import com.test.leverton.repository.URLShortnerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adarshbhattarai on 4/25/18.
 */
@Repository
//@Transactional
public class URLShortnerRepositoryImpl implements URLShortnerRepository{


    static List<URL> urls = new ArrayList<>();

    //@PersistenceContext
    // private EntityManager entityManager;
    @Override
    public URL findByURL(String longUrl) {

        URL url;
        try{
            url = urls.stream().filter(i->i.getLongUrl().equals(longUrl)).findAny().get();
        } catch (Exception e){
            url =null;
        }
        return url;
    }

    @Override
    public void remove(URL url) {
        urls.remove(url);
    }

    @Override
    public URL add(URL url) {
        urls.add(url);
        return url;
    }

    @Override
    public List<URL> getAllURL() {
        /*return entityManager.createNativeQuery("SELECT * URL)
                .getResultList();*/
        return urls;
    }
}
