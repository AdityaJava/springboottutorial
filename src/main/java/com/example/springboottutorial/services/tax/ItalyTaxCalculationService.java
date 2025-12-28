package com.example.springboottutorial.services.tax;

import com.example.springboottutorial.domain.Country;
import com.example.springboottutorial.entities.User;
import com.example.springboottutorial.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ItalyTaxCalculationService implements TaxCalculatorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItalyTaxCalculationService.class);
    private final UserService userService;

    public ItalyTaxCalculationService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public BigDecimal calculateTax(User user) {
        LOGGER.info("Calculating tax for Italy using 10% tax");
        Integer salary = user.getSalary();
        BigDecimal tax = BigDecimal.valueOf(salary * 0.1);
        user.setTax(tax);
        userService.updateUser(user, user.getId());
        return null;
    }

    @Override
    public Country supportedCountry() {
        return Country.ITALY;
    }
}
