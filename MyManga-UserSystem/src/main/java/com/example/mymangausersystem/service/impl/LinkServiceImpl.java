package com.example.mymangausersystem.service.impl;

import com.example.mymangausersystem.model.main.Manga;
import com.example.mymangausersystem.service.LinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class LinkServiceImpl implements LinkService {


    // Wordt niet meer gebruikt
    @Override
    public List<Manga> getMangaByMangaID(List<Manga> dbManga) {

        List<Manga> manga = new ArrayList<>();

        for (Manga newManga : dbManga) {
            String url = "http://localhost:8080/api/v1/manga/" + newManga.getMal_id();

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Manga> responseEntity = restTemplate.getForEntity(url, Manga.class);
            Manga response = responseEntity.getBody();
            manga.add(response);

        }
        return manga;
    }
}
