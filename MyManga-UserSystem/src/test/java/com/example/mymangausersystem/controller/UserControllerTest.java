package com.example.mymangausersystem.controller;

import com.example.mymangausersystem.model.User;
import com.example.mymangausersystem.service.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Test
    void registerUser() {
        //Arrange
        UserService mock = mock(UserService.class);
        UserController controller = new UserController(mock);

        User expected = new User("test","test@example.com","test");
        User user = null;
        when(mock.registerUser(user)).thenReturn(expected);

        //Act
        User actual = controller.registerUser(user).getBody();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void loginUser() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    void deleteUser() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    void updateUser() {
        //Arrange
        //Act
        //Assert

        //ditiseentest
    }
}