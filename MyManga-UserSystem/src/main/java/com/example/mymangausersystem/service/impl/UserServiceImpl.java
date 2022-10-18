package com.example.mymangausersystem.service.impl;

import com.example.mymangausersystem.exception.ResourceNotFoundException;
import com.example.mymangausersystem.model.User;
import com.example.mymangausersystem.repository.UserRepository;
import com.example.mymangausersystem.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    // Get all users (currently for testing purposes)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    // Get user by userID
    public User getUserByID(Long userID) {
        User user = userRepository.findById(userID).orElseThrow(
                () -> new ResourceNotFoundException("User does not exist with id:" + userID));
        return user;
    }

    @Override
    // Save a user in the database
    public User registerUser(User user) {
        User newUser = new User(user.getUserName(), user.getEmail(),
                user.getPassword());
        return userRepository.save(newUser);
    }

    @Override
    // Delete a user in the database
    public void deleteUser(Long userID) {
        User dbUser = userRepository.findById(userID).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exist with id:" + userID));

        userRepository.delete(dbUser);
    }

    // Update a user in the database
    @Override
    public User updateUser(Long userID, User user) {
        User dbUser = userRepository.findById(userID).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exist with id:" + userID));

        dbUser.setUserName(user.getUserName());
        dbUser.setEmail(user.getEmail());
        dbUser.setPassword(user.getPassword());

        userRepository.save(dbUser);
        return  dbUser;
    }

    // Login user after doing a passwordcheck, but only if the passwordcheck returns true
    @Override
    public User loginUser(String email, String password) {

        if (passwordCheck(email, password)) {
            return userRepository.findByEmail(email);
        }
        return null;
    }

    // Searches the DB for the correct match if it doesn't match or finds nothing returns false
    private Boolean passwordCheck(String email, String password) {

        String dbPassword = userRepository.findByEmail(email).getPassword();
        return Objects.equals(dbPassword, password);
    }


}
