package com.example.springboottutorial.services.tax;

import com.example.springboottutorial.domain.Country;
import com.example.springboottutorial.entities.User;
import com.example.springboottutorial.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FranceTaxCalculationService implements TaxCalculatorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FranceTaxCalculationService.class);

    private final UserService userService;

    @Autowired
    public FranceTaxCalculationService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public BigDecimal calculateTax(User user) {
        LOGGER.info("Calculating tax for France using 20% tax");
        Integer salary = user.getSalary();
        BigDecimal tax = BigDecimal.valueOf(salary * 0.2);
        user.setTax(tax);
        userService.updateUser(user, user.getId());
        return null;
    }

    @Override
    public Country supportedCountry() {
        return Country.FRANCE;
    }
}
