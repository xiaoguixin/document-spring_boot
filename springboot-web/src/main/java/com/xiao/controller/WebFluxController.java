package com.xiao.controller;

import com.xiao.entity.User;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * spring webflux有两种风格：函数式和基于注释的
 * webFlux-注解方式
 */
@RestController
@RequestMapping("/webflux1")
public class WebFluxController {

    @GetMapping("/mono/{user}")
    public Mono<User> getMonoUser(@PathVariable Long user) {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-------------end--------------");

        List<User> users = User.getUsers(user.intValue());
        return Mono.just(users.get(user.intValue()-1));
    }

    @GetMapping("/flux/{user}")
    public Flux<User> getFluxUser(@PathVariable Long user) {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-------------end--------------");

        List<User> users = User.getUsers(user.intValue());
        return Flux.just(users.get(user.intValue()-1));
    }

    @DeleteMapping("/{user}")
    public Mono<User> deleteUser(@PathVariable Long user) {
        List<User> users = User.getUsers(user.intValue());
        return Mono.just(users.get(user.intValue()-1));
    }
}

