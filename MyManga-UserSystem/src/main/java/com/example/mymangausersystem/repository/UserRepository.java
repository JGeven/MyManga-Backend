package com.example.mymangausersystem.repository;

import com.example.mymangausersystem.model.main.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
    Optional<User> findByUserName(String username);

    Optional<User> findById(User userID);
}
