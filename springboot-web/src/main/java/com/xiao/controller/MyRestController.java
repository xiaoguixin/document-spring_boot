package com.xiao.controller;

import org.springframework.web.bind.annotation.*;

/**
 * rest支持
 * RestController默认返回JSON格式
 */
@RestController
public class MyRestController {

    /**
     * 取路径中参数值
     * RequestMethod.GET可以使用GetMapping替代
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/test/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello," + name;
    }
}
