package com.example.mymangabackend.controller;

import com.example.mymangabackend.model.Manga;
import com.example.mymangabackend.model.Statistics;
import com.example.mymangabackend.service.JikanService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JikanControllerTest {

    @Test
    void getManga_Test() {
        //Arrange
        JikanService mock = mock(JikanService.class);
        JikanController controller = new JikanController(mock);
        List<Manga> expected = new ArrayList<>();

        for (int i = 0; i < 25; i++) {
            Manga tempManga = new Manga();
            tempManga.setMal_id(i);
            tempManga.setTitle("Title:" + i);
            expected.add(tempManga);
        }
        when(mock.getManga()).thenReturn(expected);

        //Act
        List<Manga> actual = controller.getManga();

        //Assert
        assertEquals(expected, actual);

    }

    @Test
    void getMangaByID_Test() {
        //Arrange
        JikanService mock = mock(JikanService.class);
        JikanController controller = new JikanController(mock);

        Manga expected = new Manga(1, "ipsum lorem", "bla bla bla");
        when(mock.getMangaByID(1)).thenReturn(expected);

        //Act
        Manga actual = controller.getMangaByID(1).getBody();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void getStatisticsOfManga_Test() {
        //Arrange
        JikanService mock = mock(JikanService.class);
        JikanController controller = new JikanController(mock);

        Statistics expected = new Statistics(1,2,3,4,5,15);
        when(mock.getStaticsOfManga(1)).thenReturn(expected);

        //Act
        Statistics actual = controller.getStatisticsOfManga(1).getBody();

        //Assert
        assertEquals(expected, actual);
    }
}