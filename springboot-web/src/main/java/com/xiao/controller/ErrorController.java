package com.xiao.controller;

import com.xiao.entity.CustomException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * MessageCodesResolver使用（未验证）
 */
@RestController
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("/one")
    public String getError(){
        throw new CustomException(500,"自定义异常处理！");
    }
}
