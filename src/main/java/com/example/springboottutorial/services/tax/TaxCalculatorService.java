package com.example.springboottutorial.services.tax;

import com.example.springboottutorial.domain.Country;
import com.example.springboottutorial.entities.User;

import java.math.BigDecimal;

public interface TaxCalculatorService {
    public BigDecimal calculateTax(User user);
    public Country supportedCountry();
}
