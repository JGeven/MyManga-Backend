package com.example.mymangabackend.service.impl;

import com.example.mymangabackend.model.Manga;
import com.example.mymangabackend.model.Statistics;
import com.example.mymangabackend.wrapper.data;
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

        // Obtaining the details of a manga fully by ID
        ResponseEntity<Manga> manga = restTemplate.exchange(baseURL+"/manga/"+mal_id, HttpMethod.GET, entity, Manga.class);
        return manga.getBody().getData();
    }

    @Override
    public Statistics getStaticsOfManga(int mal_id) {

        // Creating a rest template and entity for later use
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = null;

        // Getting the statistics of a manga by ID
        ResponseEntity<Statistics> statistics = restTemplate.exchange(baseURL+"/manga/"+mal_id+"/statistics", HttpMethod.GET, entity, Statistics.class);
        return statistics.getBody().getData();
    }

}
