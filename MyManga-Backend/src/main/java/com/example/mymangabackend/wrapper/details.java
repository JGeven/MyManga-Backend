package com.example.mymangabackend.wrapper;

import com.example.mymangabackend.model.Manga;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class details {

    @JsonProperty("data")
    Manga data;
}
