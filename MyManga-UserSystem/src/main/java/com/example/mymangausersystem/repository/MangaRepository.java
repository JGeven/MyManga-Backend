package com.example.mymangausersystem.repository;

import com.example.mymangausersystem.model.main.MangaUserLink;
import com.example.mymangausersystem.model.main.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MangaRepository  extends JpaRepository<MangaUserLink, Long> {

    List<MangaUserLink> findByUser(User user);
    void deleteByUserAndMangaID(User user, long mangaid);
}
