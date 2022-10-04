package com.example.mymangabackend.service.impl;

import com.example.mymangabackend.model.Manga;
import com.example.mymangabackend.wrapper.data;
import com.example.mymangabackend.wrapper.details;
import com.example.mymangabackend.service.JikanService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@Service
public class JikanServiceImpl implements JikanService {

    private static String baseURL = "https://api.jikan.moe/v4";

    @Override
    public List<Manga> getManga() {

        // Creating a rest template and entity for later use
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = null;

        // Filling the response entity with data to add to a list
        ResponseEntity<data> manga = restTemplate.exchange(baseURL+"/manga", HttpMethod.GET,entity,data.class);
        return List.of(manga.getBody().getData());
    }

    @Override
    public Manga getMangaByID(int mal_id) {

        // Creating a rest template and entity for later use
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = null;

        ResponseEntity<details> manga = restTemplate.exchange(baseURL+"/manga/"+mal_id, HttpMethod.GET, entity, details.class);
        return manga.getBody().getData();
    }

}
