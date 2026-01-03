package com.example.springboottutorial.domain;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    public SingletonBean() {
        System.out.println("SingletonBean created " + this.hashCode());
    }
}
