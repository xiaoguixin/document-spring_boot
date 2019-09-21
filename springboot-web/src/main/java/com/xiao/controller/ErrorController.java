package com.xiao.controller;

import com.xiao.entity.CustomizeException;
import com.xiao.entity.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * MessageCodesResolver使用（未验证）
 */
@RestController
@RequestMapping("/error")
public class ErrorController {

    /**
     * 返回自定义的异常
     * @return
     */
    @RequestMapping("/one")
    public String getErrorOne(){
        throw new CustomizeException(500,"自定义异常处理！");
    }

    /**
     * 如果客户端不传入id，会报空指针异常很难判断哪里错误
     * @param id
     * @return
     */
    @RequestMapping("/two")
    public User getErrorTwo(@Validated Long id){
        System.out.println("--77777--");
        List<User> users = User.getUsers(id.intValue());
        return users.get(0);
    }
}
