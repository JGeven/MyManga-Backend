package com.example.mymangausersystem.service.impl;

import com.example.mymangausersystem.model.main.Manga;
import com.example.mymangausersystem.model.main.MangaUserLink;
import com.example.mymangausersystem.model.main.User;
import com.example.mymangausersystem.repository.MangaRepository;
import com.example.mymangausersystem.repository.UserRepository;
import com.example.mymangausersystem.service.MangaService;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MangaServiceImpl implements MangaService {

    private final MangaRepository mangaRepository;
    private final UserRepository userRepository;


    public MangaServiceImpl(MangaRepository mangaRepository, UserRepository userRepository) {
        this.mangaRepository = mangaRepository;
        this.userRepository = userRepository;
    }

    // Save favorite manga to DB table
    @Override
    public boolean favoriteManga(long mangaID, long userID) {
        MangaUserLink mangaUserLink = new MangaUserLink();
        mangaUserLink.setMangaID(mangaID);
        User dbUser = userRepository.findById(userID).orElseThrow(() -> new ExpressionException("user not found"));
        mangaUserLink.setUser(dbUser);

        mangaRepository.save(mangaUserLink);
        return true;
    }

    // Delete favorite manga from DB table
    @Override
    @Transactional
    public boolean unfavoriteManga(long mangaID, long userID) {

        User dbUser = userRepository.findById(userID).orElseThrow(() -> new ExpressionException("user not found"));
        mangaRepository.deleteByUserAndMangaID(dbUser,mangaID);
        return true;
    }

    // Get favorite manga from DB table
    @Override
    public List<Manga> getMangabyUserID(long userID) {
        List<Manga> mangas = new ArrayList<>();

        User dbUser = userRepository.findById(userID).orElseThrow(() -> new ExpressionException("user not found"));
        for (MangaUserLink dbManga : mangaRepository.findByUser(dbUser)) {
            Manga manga = new Manga();
            manga.setMal_id(dbManga.getMangaID());
            mangas.add(manga);
        }
        return mangas;
    }
}
