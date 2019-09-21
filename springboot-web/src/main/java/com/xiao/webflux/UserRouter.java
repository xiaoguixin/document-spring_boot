package com.xiao.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * webFlux-函数式
 * 用户信息路由类
 * 工程启动时添加到系统中
 */
@Configuration
public class UserRouter {

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(UserHandler userHandler) {
        return route(GET("/webflux2/mono/{user}").and(accept(TEXT_PLAIN)), userHandler::getMonoUser)
            .andRoute(DELETE("/webflux2/{user}").and(accept(TEXT_PLAIN)), userHandler::deleteUser);
    }
}
