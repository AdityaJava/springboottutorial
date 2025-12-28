package com.example.springboottutorial.services.tax;

import com.example.springboottutorial.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaxFactory {
    Map<Country, TaxCalculatorService> countryTaxCalculatorServiceMap;

    @Autowired
    public TaxFactory(List<TaxCalculatorService> taxCalculatorServiceList) {
        countryTaxCalculatorServiceMap = new HashMap<>();
        createMap(taxCalculatorServiceList);
    }

    private void createMap(List<TaxCalculatorService> taxCalculatorServiceList) {
        taxCalculatorServiceList.forEach(taxCalculatorService -> {
            countryTaxCalculatorServiceMap.put(taxCalculatorService.supportedCountry(), taxCalculatorService);
        });
    }

    public TaxCalculatorService getServiceByCountry(Country country) {
        return countryTaxCalculatorServiceMap.get(country);
    }

}
