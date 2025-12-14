package com.example.springboottutorial.scopetesting;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserServiceScopeRequest {

    @PostConstruct
    public void postC() {
        System.out.println("UserServiceScopeRequest hashcode:" + this.hashCode());
    }

    public String sayHello() {
        return "Hello from Scope request";
    }
}
