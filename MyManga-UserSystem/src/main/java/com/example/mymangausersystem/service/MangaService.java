package com.example.mymangausersystem.service;

import com.example.mymangausersystem.model.main.Manga;

import java.util.List;

public interface MangaService {
    // Save favorite manga to DB table
    boolean favoriteManga(long mangaID, long userID);

    // Delete favorite manga from DB table
    boolean unfavoriteManga(long mangaID, long userID);

    // Get favorite manga from DB table
    List<Manga> getMangabyUserID(long userID);
}
