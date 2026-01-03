package com.example.springboottutorial.domain;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "app.mode", havingValue = "dev", matchIfMissing = true)
public class DevBean implements ModeInterface {

    @Override
    public void work() {
        System.out.println("Dev work");
    }
}
