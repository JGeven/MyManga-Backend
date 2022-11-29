package com.example.mymangausersystem.model.main;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "favorites")
public class MangaUserLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long linkID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "manga_id")
    private Long mangaID;
}
