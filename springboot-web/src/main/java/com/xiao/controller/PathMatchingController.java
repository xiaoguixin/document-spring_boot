package com.xiao.controller;

import com.xiao.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Spring MVC可以通过查看请求路径并将其与应用程序中定义的映射
 * （例如，控制器方法上@GetMapping注解）匹配，将传入的HTTP请求映射到处理程序。
 */
@RestController
public class PathMatchingController {


    @GetMapping(value="/projects/spring-boot",produces="application/json")
    public List<User> markdown(){
        List<User> users = User.getUsers(10);
        return users;
    }
}
