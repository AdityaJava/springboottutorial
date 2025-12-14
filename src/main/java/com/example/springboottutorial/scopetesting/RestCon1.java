package com.example.springboottutorial.scopetesting;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/scopetest1")
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RestCon1 {

    private final UserServiceScopePrototype userServiceScopePrototype;

    private final UserServiceScopeRequest userServiceScopeRequest;

    @Autowired
    public RestCon1(UserServiceScopePrototype userServiceScopePrototype, UserServiceScopeRequest userServiceScopeRequest) {
        this.userServiceScopePrototype = userServiceScopePrototype;
        this.userServiceScopeRequest = userServiceScopeRequest;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("RestCon1 hashcode = " + this.hashCode());
    }

    @GetMapping("/test")
    public String test() {
        return userServiceScopePrototype.sayHEllo();
    }

    @GetMapping("/scopeRequesttest")
    public String scopeRequesttest() {
        return userServiceScopeRequest.sayHello();
    }

}
