package com.example.springboottutorial.services;

import com.example.springboottutorial.UserSpecification;
import com.example.springboottutorial.entities.User;

import com.example.springboottutorial.DTO.UserDTO;
import com.example.springboottutorial.filter.UserFilter;
import com.example.springboottutorial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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

    public Page<User> getAllUsers(Pageable pageable, UserFilter userFilter) {
        Specification<User> userSpecification = null;
        if (userFilter.getName() != null) {
            userSpecification = UserSpecification.hasName(userFilter.getName());
        }
        if (userFilter.getAge() != null) {
            userSpecification = userSpecification != null ? userSpecification.and(UserSpecification.hasAge(userFilter.getAge())) : UserSpecification.hasAge(userFilter.getAge());
        }
        return userRepository.findAll(userSpecification, pageable);
    }

    @Transactional
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

    @Transactional
    public void resetTax(Long id) {
        User user = userRepository.findById(id).get();
        user.setTax(BigDecimal.ZERO);
    }

//    public List<UserDTO> get(String aditya, Pageable pageable, Sort sort) {
//        Page<User> users = userRepository.findByAge(12, pageable, sort);
//        return userRepository.findUserDTO(aditya);
//    }
}
