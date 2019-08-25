package com.xiao.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * rest支持
 */
@RestController
public class MyRestController {

    @RequestMapping("/test/{name}")
    public String sayHello(@PathVariable String name){
        return "Hello,"+name;
    }
}
