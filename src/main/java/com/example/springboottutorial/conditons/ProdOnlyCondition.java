package com.example.springboottutorial.conditons;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ProdOnlyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//        String appMode = context.getEnvironment().getProperty("app.mode");
//        return appMode.equals("prod");
        return true;
    }
}
