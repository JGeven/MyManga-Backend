package com.example.mymangabackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Statistics {

    @JsonProperty("data")
    Statistics data;

    @JsonProperty("reading")
    private int reading;
    @JsonProperty("completed")
    private int completed;
    @JsonProperty("on_hold")
    private int on_hold;
    @JsonProperty("dropped")
    private int dropped;
    @JsonProperty("plan_to_read")
    private int plan_to_read;
    @JsonProperty("total")
    private int total;

    public Statistics() {

    }

    public Statistics(int reading, int completed, int on_hold, int dropped, int plan_to_read, int total) {
        this.reading = reading;
        this.completed = completed;
        this.on_hold = on_hold;
        this.dropped = dropped;
        this.plan_to_read = plan_to_read;
        this.total = total;
    }
}
