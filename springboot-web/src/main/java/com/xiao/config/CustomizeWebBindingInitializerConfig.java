package com.xiao.config;

import com.xiao.editor.DateEditor;
import com.xiao.editor.StringEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.validation.Validator;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;

import java.util.Date;

/**
 * spring mvc使用webindinginitializer为特定请求初始化webdatabinder
 * 功能和CustomizeHttpMessageConverterConfig相同
 */
@Configuration
public class CustomizeWebBindingInitializerConfig {

    @Bean
    public ConfigurableWebBindingInitializer configurableWebBindingInitializer(FormattingConversionService mvcConversionService, Validator mvcValidator) {
        ConfigurableWebBindingInitializer initializer = new ConfigurableWebBindingInitializer();
        initializer.setConversionService(mvcConversionService);
        initializer.setValidator(mvcValidator);
        //装配自定义属性编辑器
        initializer.setPropertyEditorRegistrar(propertyEditorRegistry -> {
            //PropertyEditors并不是线程安全的，对于每一个请求，我们都需要new一个PropertyEditor对象
            propertyEditorRegistry.registerCustomEditor(String.class, new StringEditor());
            propertyEditorRegistry.registerCustomEditor(Date.class, new DateEditor());
        });
        return initializer;
    }
}
