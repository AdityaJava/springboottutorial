package com.example.springboottutorial.domain;

public enum Country {
    INDIA("INDIA"),
    FRANCE("FRANCE"),
    ITALY("ITALY");

    private String value;

    Country(String value) {
        this.value = value;
    }
}
