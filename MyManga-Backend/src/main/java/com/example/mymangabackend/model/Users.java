package com.example.mymangabackend.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private long id;

    @Column(name = "user_name")
    @Getter @Setter
    private String userName;

    @Column(name = "email")
    @Getter @Setter
    private String email;

    @Column(name = "password")
    @Getter @Setter
    private String password;

    public Users() {

    }

    public Users(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public Users(long id, String userName, String email, String password) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }


}
