package com.xiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 演示springboot的Web MVC
 * 放到resources下或者使用下面设置
 * spring.mvc.favicon.enabled=false
 * <link rel="icon" type="image/x-icon" href="img/favicon.ico">
 *
 */
@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(WebApplication.class);
        /*
         * 同时增加spring-boot-starter-web和spring-boot-starter-webflux会自动配置为SpringMvc，
         * 只能使用解释式WebFlux。
         * 使用如下代码使函数式和注解式都可以用
         */
        app.setWebApplicationType(WebApplicationType.REACTIVE);
        app.run(args);
    }
}
