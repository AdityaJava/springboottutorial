package com.example.springboottutorial.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicApi {

    @GetMapping
    public String publicApi() {
        return "sd";
    }
}
