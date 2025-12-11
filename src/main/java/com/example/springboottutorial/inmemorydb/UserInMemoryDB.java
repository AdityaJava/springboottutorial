package com.example.springboottutorial.inmemorydb;

import com.example.springboottutorial.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserInMemoryDB {
    List<User> userList;
    Long id = 5L;

    public UserInMemoryDB() {
        userList = new ArrayList<>();
        this.userList.add(new User(1L, "kartikeya", "admin", 28));
        this.userList.add(new User(2L, "Aditya", "user", 28));
        this.userList.add(new User(3L, "Shubham", "admin", 28));
        this.userList.add(new User(4L, "Nayan", "user", 28));
    }

    public User getUserById(Long id) {
        return userList.stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }

    public List<User> getUsers() {
        return this.userList;
    }

    public User createUser(User user) {
        user.setId(id++);
        this.userList.add(user);
        return user;
    }

    public User updateUser(User user, Long userId) {
        User existingUser = getUserById(userId);
        if (existingUser != null) {
            userList.remove(existingUser);
            userList.add(user);
        }
        return user;
    }

    public void deleteUser(Long id) {
        User existingUser = getUserById(id);
        if (existingUser != null) {
            userList.remove(existingUser);
        }
    }
}
