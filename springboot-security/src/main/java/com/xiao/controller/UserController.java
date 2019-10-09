package com.xiao.controller;

import com.xiao.entity.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户控制器
 */
@RestController
@RequestMapping(value="/user")
public class UserController {

    @RequestMapping(value="/select")
    public List<User> select(){
        List<User> list = new ArrayList<>();
        list.add(new User(10L,"zhangsan",null));
        list.add(new User(11L,"zhangsan",null));
        list.add(new User(12L,"zhangsan",null));
        return list;
    }

    @RequestMapping(value="/add")
    public User add(){
        return new User(100L,"zhangsan",null);
    }

    @RequestMapping(value="/edit")
    public User edit(Long id){
        return new User(id,"zhangsan",null);
    }


    @RequestMapping(value="/del")
    public User select(Long id){
        return new User(id,"zhangsan",null);
    }
}
