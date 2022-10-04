package com.example.mymangabackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Manga {


    @JsonProperty("mal_id")
    private int mal_id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("synopsis")
    private String synopsis;

    public Manga() {

    }

    public Manga(String title, String synopsis) {
        this.title = title;
        this.synopsis = synopsis;
    }

    public Manga(int mal_id, String title, String synopsis) {
        this.mal_id = mal_id;
        this.title = title;
        this.synopsis = synopsis;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "mal_id=" + mal_id +
                '}';
    }
}
