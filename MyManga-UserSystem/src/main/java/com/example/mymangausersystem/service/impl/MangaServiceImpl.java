package com.example.mymangausersystem.service.impl;

import com.example.mymangausersystem.model.main.Manga;
import com.example.mymangausersystem.model.main.MangaUserLink;
import com.example.mymangausersystem.repository.MangaRepository;
import com.example.mymangausersystem.service.MangaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MangaServiceImpl implements MangaService {

    private final MangaRepository mangaRepository;


    public MangaServiceImpl(MangaRepository mangaRepository) {
        this.mangaRepository = mangaRepository;
    }

    // Save favorite manga to DB table
    @Override
    public boolean favoriteManga(long mangaID, long userID) {
        MangaUserLink mangaUserLink = new MangaUserLink();
        mangaUserLink.setMangaID(mangaID);
        mangaUserLink.setUserID(userID);

        mangaRepository.save(mangaUserLink);
        return true;
    }

    // Delete favorite manga from DB table
    @Override
    public boolean unfavoriteManga(long mangaID, long userID) {
        mangaRepository.deleteByUserIDAndMangaID(userID,mangaID);
        return true;
    }

    // Get favorite manga from DB table
    @Override
    public List<Manga> getMangabyUserID(long userID) {
        List<Manga> mangas = new ArrayList<>();

        for (MangaUserLink dbManga : mangaRepository.findByUserID(userID)) {
            Manga manga = new Manga();
            manga.setMal_id(dbManga.getMangaID());
            mangas.add(manga);
        }
        return mangas;
    }
}
