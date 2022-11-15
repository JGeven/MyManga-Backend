package com.example.mymangausersystem.repository;

import com.example.mymangausersystem.model.main.MangaUserLink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MangaRepository  extends JpaRepository<MangaUserLink, Long> {

    List<MangaUserLink> findByUserID(long id);
    void deleteByUserIDAndMangaID(long userid, long mangaid);
}
