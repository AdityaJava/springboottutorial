package com.example.springboottutorial.scopetesting.sessionscope;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.SessionScope;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
//@SessionScope
public class UserServiceScopeSession {

    @PostConstruct
    public void postCon() {
        System.out.println("UserServiceScopeSession post construct" + this.hashCode());
    }

    public String sayHello() {
        return "saySessionScopeHello";
    }
}
