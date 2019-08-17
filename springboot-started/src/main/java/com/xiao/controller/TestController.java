package com.xiao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/started")
public class TestController {

    @RequestMapping("/")
    public String home(){
        return "springbooot-started started";
    }
}
