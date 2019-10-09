package com.xiao.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * 登录控制类
 */
@Slf4j
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "redirect:/public/login.html";
    }

}
