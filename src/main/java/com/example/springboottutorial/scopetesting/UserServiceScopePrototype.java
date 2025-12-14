package com.example.springboottutorial.scopetesting;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserServiceScopePrototype {

    @PostConstruct
    public void postConstruct() {
        System.out.println("UserServiceScopePrototype hashcode = " + this.hashCode());
    }

    public String sayHEllo() {
        return "Hello";
    }
}
