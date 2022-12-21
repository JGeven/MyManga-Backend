package com.example.mymangabackend.controller;

import com.example.mymangabackend.model.Manga;
import com.example.mymangabackend.model.Statistics;
import com.example.mymangabackend.service.JikanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class JikanController {

    @Autowired
    private final JikanService jikanService;

    public JikanController(JikanService jikanService) {
        super();
        this.jikanService = jikanService;
    }

    // Gets all manga from Jikan API
    @GetMapping("/manga")
    public List<Manga> getManga() {
        return jikanService.getManga();
    }

    // Get manga by ID from Jikan API
    @GetMapping("/manga/{mal_id}")
    public ResponseEntity<Manga> getMangaByID(@PathVariable int mal_id) {
        Manga manga = jikanService.getMangaByID(mal_id);
        return ResponseEntity.ok(manga);
    }

    // Get statistics of manga from Jikan API
    @GetMapping("/manga/{mal_id}/statistics")
    public ResponseEntity<Statistics> getStatisticsOfManga(@PathVariable int mal_id) {
        Statistics statistics = jikanService.getStaticsOfManga(mal_id);
        return  ResponseEntity.ok(statistics);
    }

}
