package com.example.mymangabackend.service;

import com.example.mymangabackend.model.Manga;
import com.example.mymangabackend.model.Statistics;

import java.util.List;

public interface JikanService {

    List<Manga> getManga();

    Manga getMangaByID(int mal_id);

    Statistics getStaticsOfManga(int mal_id);
}
