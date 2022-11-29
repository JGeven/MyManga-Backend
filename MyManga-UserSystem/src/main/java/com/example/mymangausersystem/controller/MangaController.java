package com.example.mymangausersystem.controller;

import com.example.mymangausersystem.model.main.Manga;
import com.example.mymangausersystem.service.LinkService;
import com.example.mymangausersystem.service.MangaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manga")
@CrossOrigin(origins = "*")
public class MangaController {

    private final LinkService linkService;
    private final MangaService mangaService;

    public MangaController(LinkService linkService, MangaService mangaService) {
        this.linkService = linkService;
        this.mangaService = mangaService;
    }

    // Favorite/Save manga in Link table
    @PostMapping
    public ResponseEntity<Boolean> favoriteManga(@RequestParam Long mangaID, @RequestParam Long userID) {
        return new ResponseEntity<>(mangaService.favoriteManga(mangaID,userID), HttpStatus.OK);
    }

    // Unfavorite/Delete manga in Link table
    @DeleteMapping
    public ResponseEntity<Boolean> unfavoriteManga(@RequestParam Long mangaID, @RequestParam Long userID) {
        return new ResponseEntity<>(mangaService.unfavoriteManga(mangaID,userID), HttpStatus.OK);
    }

    // Get manga from Manga backend
    @GetMapping
    public List<Manga> getFavoriteMangaByUserID(@RequestParam Long userID) {
        return mangaService.getMangabyUserID(userID);
    }
}
