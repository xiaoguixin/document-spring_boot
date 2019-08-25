package com.xiao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class ProductionConfiguration1 implements Production {


    @Override
    public String getProductName() {
        return "dev";
    }
}
