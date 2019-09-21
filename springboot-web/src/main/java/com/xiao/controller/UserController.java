package com.xiao.controller;

import com.xiao.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Controller需要加ResponseBody
 * @RestController可以不用加ResponseBody默认返回Json格式数据
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable @NotNull Long id) {
        List<User> users = User.getUsers(id.intValue());
        return users.get(id.intValue()-1);
    }

    @RequestMapping(value = "/{id}/customers", method = RequestMethod.GET)
    List<User> getUserCustomers(@PathVariable Long id) {
        List<User> users = User.getUsers(id.intValue());
        return users;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable Long id) {
        List<User> users = User.getUsers(id.intValue());
        return users.get(id.intValue()-1);
    }
}