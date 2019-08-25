package com.xiao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class ProductionConfiguration2 implements Production {

    @Override
    public String getProductName() {
        return "test";
    }
}
