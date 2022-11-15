package com.example.mymangausersystem.service;

import com.example.mymangausersystem.model.main.Manga;

import java.util.List;

public interface LinkService {
    List<Manga> getMangaByMangaID(List<Manga> dbManga);
}
