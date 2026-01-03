package com.example.springboottutorial.controllers;

import com.example.springboottutorial.domain.PrototypeUserBean;
import com.example.springboottutorial.domain.RequestUserBean;
import com.example.springboottutorial.domain.SessionUserBean;
import com.example.springboottutorial.domain.SingletonBean;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scope-test")
public class ScopeTestController {

    private PrototypeUserBean prototypeUserBean;

    private final ApplicationContext applicationContext;

    private final RequestUserBean requestUserBean;

    private final SessionUserBean sessionUserBean;

    @Autowired
    public ScopeTestController(PrototypeUserBean prototypeUserBean, ApplicationContext applicationContext, RequestUserBean requestUserBean, SessionUserBean sessionUserBean) {
        this.prototypeUserBean = prototypeUserBean;
        this.applicationContext = applicationContext;
        this.requestUserBean = requestUserBean;
        this.sessionUserBean = sessionUserBean;
    }

    @GetMapping("/prototype")
    public String prototypeTest() {
        PrototypeUserBean prototypeUserBean1 = applicationContext.getBean(PrototypeUserBean.class);
        SingletonBean singletonBean = applicationContext.getBean(SingletonBean.class);
        System.out.println("SingletonBean hashcode " + singletonBean.hashCode());
        return "Prototype tested" + prototypeUserBean1.hashCode();
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

    @GetMapping("/session/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }
}
