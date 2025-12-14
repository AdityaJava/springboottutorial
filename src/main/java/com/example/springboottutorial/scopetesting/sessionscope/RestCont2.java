package com.example.springboottutorial.scopetesting.sessionscope;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class RestCont2 {

    private final UserServiceScopeSession userServiceScopeSession;

    @Autowired
    public RestCont2(UserServiceScopeSession userServiceScopeSession) {
        this.userServiceScopeSession = userServiceScopeSession;
    }

    @GetMapping
    public String saySessionScopeHello() {
        return userServiceScopeSession.sayHello();
    }

    @GetMapping("/logout")
    public void logut(HttpServletRequest httpServletRequest) {
        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.invalidate();
    }

}
