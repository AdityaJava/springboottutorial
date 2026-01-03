package com.example.springboottutorial.domain;

import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeUserBean {

    public PrototypeUserBean() {
        System.out.println("PrototypeUserBean created: " + this.hashCode());
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Before destroying PrototypeUserBean");
    }
}
