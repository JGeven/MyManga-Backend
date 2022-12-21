package com.example.mymangausersystem.model.main;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Manga {

    @JsonProperty("data")
    Manga data;

    @JsonProperty("mal_id")
    private Long mal_id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("synopsis")
    private String synopsis;
}
