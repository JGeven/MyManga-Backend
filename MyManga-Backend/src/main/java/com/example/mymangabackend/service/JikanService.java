package com.example.mymangabackend.service;

import com.example.mymangabackend.model.Manga;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JikanService {

    List<Manga> getManga();

    Manga getMangaByID(int mal_id);
}
