package com.xiao.controller;

import com.alibaba.fastjson.JSONObject;
import com.xiao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * redis存储
 * Validated的使用
 * 发送邮件
 */
@RestController
@Validated
@RequestMapping("/redis")
public class UserController {

    AtomicInteger atomicInteger = new AtomicInteger(1);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Autowired
    private SimpleMailMessage simpleMailMessage;

    /**
     * 根据ID获取用户信息
     * @param id
     * @return
     */
    @RequestMapping("/user/get")
    public String getUser(int id){
        if(redisTemplate.hasKey(id)){
            String u = (String) redisTemplate.opsForValue().get(id);
            return JSONObject.parse(u).toString();
        }
        return null;
    }

    /**
     * 缓存用户信息
     * @param name
     * @param age
     */
    @RequestMapping("/user/add")
    public String addUser(@NotBlank String name,int age){
        User user = new User();
        user.setId(atomicInteger.get());
        user.setName(name);
        user.setAge(age);

        redisTemplate.expire(atomicInteger.get(), 20, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set(atomicInteger.get(), JSONObject.toJSONString(user));
        atomicInteger.getAndIncrement();

        // 注册成功发送邮件
        SimpleMailMessage msg = new SimpleMailMessage(simpleMailMessage);
        msg.setTo("463267022@qq.com");
        msg.setText("Dear thank you for placing order. Your order number is ");
        javaMailSender.send(msg);

        return JSONObject.toJSONString(user);
    }
}
