package com.example.springboottutorial.services.tax;

import com.example.springboottutorial.domain.Country;
import com.example.springboottutorial.entities.User;
import com.example.springboottutorial.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigDecimal;

@Service
public class FranceTaxCalculationService implements TaxCalculatorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FranceTaxCalculationService.class);

    private final UserService userService;

    private final PlatformTransactionManager platformTransactionManager;

    private TransactionTemplate transactionTemplate;

    @Autowired
    public FranceTaxCalculationService(UserService userService, PlatformTransactionManager platformTransactionManager) {
        this.userService = userService;
        this.platformTransactionManager = platformTransactionManager;
        this.transactionTemplate = new TransactionTemplate(platformTransactionManager);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public BigDecimal calculateTax(User user) {
//        transactionTemplate.execute(status -> {
//            LOGGER.info("Calculating tax for France using 20% tax");
//            Integer salary = user.getSalary();
//            BigDecimal tax = BigDecimal.valueOf(salary * 0.2);
//            user.setTax(tax);
//            userService.updateUser(user, user.getId());
//            userService.raiseException();
//            return null;
//        });
        System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
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
