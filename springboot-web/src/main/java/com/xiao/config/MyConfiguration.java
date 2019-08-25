package com.xiao.config;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;

@Configuration
public class MyConfiguration {

    @Bean
    public HttpMessageConverters customConverters(){
        HttpMessageConverter<String> str = new StringHttpMessageConverter();
        
        return new HttpMessageConverters(str);
    }
}
