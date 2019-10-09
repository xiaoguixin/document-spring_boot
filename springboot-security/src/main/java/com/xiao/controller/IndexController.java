package com.xiao.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统首页
 */
@Slf4j
@Controller
public class IndexController {

    /**
     * 跳转系统首页
     *
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        log.info("Welcome to Index!");
        return "redirect:/public/index.html";
    }
}
