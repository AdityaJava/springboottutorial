package com.example.springboottutorial.services;

import com.example.springboottutorial.annotations.MyAnnotation;
import com.example.springboottutorial.entities.User;

import com.example.springboottutorial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

  //  @MyAnnotation
    public User getUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User updatedUser, Long userId) {
        User existingUser = getUserById(userId);
        if (existingUser != null) {
            return userRepository.save(updatedUser);
        }
        return null;
    }

    public void raiseException() {
        /**
         * Business logic
         */

        // Imagine Business logic fails
        throw new RuntimeException();
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
