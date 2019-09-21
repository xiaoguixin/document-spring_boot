package com.xiao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 *
 * 一个项目中只能存在一个WebMvcConfigurationSupport
 */
@Configuration
public class CustomizeSpringMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 视图控制器
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 自动跳转到欢迎界面
        registry.addViewController("/").setViewName("forward:/public/index.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }
}
