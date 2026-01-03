package com.example.springboottutorial.domain;

import com.example.springboottutorial.conditons.ProdOnlyCondition;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//@Conditional(ProdOnlyCondition.class)
@Service
@ConditionalOnProperty(name = "app.mode", havingValue = "prod")
@Profile("prod")
public class ProductionBean implements ModeInterface {

    @PostConstruct
    public void postConstruct() {
        System.out.println("Production bean");
    }

    public void work() {
        System.out.println("Production work");
    }
}
