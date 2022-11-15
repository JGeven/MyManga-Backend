package com.example.mymangausersystem.controller;

import com.example.mymangausersystem.model.main.User;
import com.example.mymangausersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    PasswordEncoder passwordEncoder;
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Register/Save user to database
    @PostMapping("/users")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User dbUser = userService.registerUser(user);
        return ResponseEntity.ok(dbUser);
    }

    // Get user from database
    @GetMapping("/users")
    public ResponseEntity<User> getUser(@RequestParam long userID) {
        User user = userService.getUserByID(userID);
        return ResponseEntity.ok(user);
    }

    // Delete user from database
    @DeleteMapping("/users")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@RequestParam Long userID) {
        userService.deleteUser(userID);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    // Update user from database
    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestParam Long userID, @RequestBody User user) {
        User dbUser = userService.updateUser(userID,user);
        return ResponseEntity.ok(dbUser);
    }
}
