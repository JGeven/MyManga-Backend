package com.example.mymangabackend.controller;

import com.example.mymangabackend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vi/")
@CrossOrigin
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;


}
