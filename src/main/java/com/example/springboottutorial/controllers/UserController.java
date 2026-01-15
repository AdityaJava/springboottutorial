package com.example.springboottutorial.controllers;

import com.example.springboottutorial.domain.ProductionBean;
import com.example.springboottutorial.entities.User;
import com.example.springboottutorial.services.UserService;
import com.example.springboottutorial.services.tax.TaxCalculatorService;
import com.example.springboottutorial.services.tax.TaxFactory;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    private final TaxFactory taxFactory;


    @Autowired
    public UserController(UserService userService, TaxFactory taxFactory, ObjectProvider<ProductionBean> productionBean) {
        this.userService = userService;
        this.taxFactory = taxFactory;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long userId, HttpServletRequest request, HttpServletResponse response) {
        User user = userService.getUserById(userId);
        return userService.getUserById(userId);
    }
    //((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization")
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User updatedUser, @PathVariable("id") Long userId) {
        return userService.updateUser(updatedUser, userId);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
    }

    @PostMapping("/{id}/calculateTax")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public void controllerCalculateTax(@PathVariable("id") Long userId) {
        User user = userService.getUserById(userId);
        TaxCalculatorService taxCalculatorService = taxFactory.getServiceByCountry(user.getCountry());
        System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
        taxCalculatorService.calculateTax(user);
    }

    @PostMapping("/resetTax/{id}")
    public void resetTax(@PathVariable Long id){
        userService.resetTax(id);
    }

}
