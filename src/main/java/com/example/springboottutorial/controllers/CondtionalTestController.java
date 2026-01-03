package com.example.springboottutorial.controllers;

import com.example.springboottutorial.domain.ModeInterface;
import com.example.springboottutorial.domain.ProductionBean;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/condtional-test")
public class CondtionalTestController {
    private final ObjectProvider<ProductionBean> productionBean;

    private final ModeInterface modeInterface;

    @Autowired
    public CondtionalTestController(ObjectProvider<ProductionBean> productionBean, ModeInterface modeInterface) {
        this.productionBean = productionBean;
        this.modeInterface = modeInterface;
    }

    @GetMapping()
    public void check() {
//        ProductionBean productionBean1 = productionBean.getIfAvailable();
//        if (productionBean1 == null) {
//            System.out.println("This is outside production");
//        } else {
//            productionBean1.work();
//        }
        modeInterface.work();
    }
}
