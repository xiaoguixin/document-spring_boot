package com.xiao.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xiao.serialize.CustomizeJsonSerialize;
import com.xiao.serialize.DoubleSerialize;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Data
public class User {

    private Long id;
    private String name;
    private int age;
    private String address;
    @JsonSerialize(using = DoubleSerialize.class)
    private Double salary;
    @JsonSerialize(using = CustomizeJsonSerialize.BirthdaySerializer.class)
    private Date birthday;

    /**
     * 批量生成用户
     * @param count
     * @return
     */
    public static List<User> getUsers(int count) {
        List<User> list = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            User u = new User();
            u.setId(Long.valueOf(i));
            u.setName("hello " + i);
            u.setAge(random.nextInt(100));
            u.setSalary(random.nextDouble()*10000);
            u.setBirthday(new Date());

            list.add(u);
        }

        return list;
    }
}
