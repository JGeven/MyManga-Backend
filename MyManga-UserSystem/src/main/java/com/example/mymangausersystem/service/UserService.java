package com.example.mymangausersystem.service;

import com.example.mymangausersystem.model.main.User;

import java.util.List;

public interface UserService {

    // Get all users (currently for testing purposes)
    List<User> getAllUsers();

    // Get user by userID
    User getUserByID(Long userID);

    // Save a user in the database
    User registerUser(User user);

    // Delete a user in the database
    void deleteUser(Long userID);

    // Update a user in the database
    User updateUser(Long userID, User user);

    User loginUser(String email, String password);
}
