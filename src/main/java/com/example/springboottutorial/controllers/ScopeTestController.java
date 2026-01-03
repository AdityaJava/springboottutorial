package com.example.springboottutorial.controllers;

import com.example.springboottutorial.domain.PrototypeUserBean;
import com.example.springboottutorial.domain.RequestUserBean;
import com.example.springboottutorial.domain.SessionUserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scope-test")
public class ScopeTestController {

    private final PrototypeUserBean prototypeUserBean;

    private final RequestUserBean requestUserBean;

    private final SessionUserBean sessionUserBean;

    @Autowired
    public ScopeTestController(PrototypeUserBean prototypeUserBean, RequestUserBean requestUserBean, SessionUserBean sessionUserBean) {
        this.prototypeUserBean = prototypeUserBean;
        this.requestUserBean = requestUserBean;
        this.sessionUserBean = sessionUserBean;
    }

    @GetMapping("/prototype")
    public String prototypeTest() {
        return "Prototype tested" + prototypeUserBean.hashCode();
    }

    @GetMapping("/request")
    public String requestTest() {
        return "Request Bean Hash: " + requestUserBean.hashCode();
    }

    @GetMapping("/session/{name}")
    public String sessionTest(@PathVariable String name) {
        sessionUserBean.setLoggedInUser(name);
        return "Session Bean Hash: " + sessionUserBean.hashCode()
                + ", User: " + sessionUserBean.getLoggedInUser();
    }
}
