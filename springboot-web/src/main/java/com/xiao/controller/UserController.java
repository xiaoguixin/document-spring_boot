package com.xiao.controller;

import com.xiao.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * RestController可以不用加ResponseBody默认返回Json格式数据
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        List<User> users = User.getUsers(id.intValue());
        return users.get(0);
    }

    @RequestMapping(value = "/{id}/customers", method = RequestMethod.GET)
    List<User> getUserCustomers(@PathVariable Long id) {
        List<User> users = User.getUsers(id.intValue());
        return users;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable Long id) {
        List<User> users = User.getUsers(id.intValue());
        return users.get(0);
    }

}