package com.example.springboottutorial.services;

import com.example.springboottutorial.entities.User;
import com.example.springboottutorial.inmemorydb.UserInMemoryDB;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserInMemoryDB userInMemoryDB;

    public UserService() {
        userInMemoryDB = new UserInMemoryDB();
    }

    public User getUserById(Long userId) {
        return userInMemoryDB.getUserById(userId);
    }

    public List<User> getAllUsers() {
        return userInMemoryDB.getUsers();
    }

    public User createUser(User user) {
        return userInMemoryDB.createUser(user);
    }

    public User updateUser(User updatedUser, Long userId) {
        return userInMemoryDB.updateUser(updatedUser, userId);
    }

    public void deleteUser(Long userId) {
        userInMemoryDB.deleteUser(userId);
    }
}
