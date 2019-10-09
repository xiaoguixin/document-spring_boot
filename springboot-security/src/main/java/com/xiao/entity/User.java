package com.xiao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息
 */
@Data
@ToString
@AllArgsConstructor
public class User {

    private Long id;
    private String account;
    private String password;

    // 用户列表
    private final static List<User> list;
    static {
        list = new ArrayList<>();
        list.add(new User(1L,"admin", "123456"));
        list.add(new User(2L,"test", "123456"));
        list.add(new User(3L,"customer1", "123456"));
        list.add(new User(4L,"customer2", "123456"));
    }

    /**
     * 模拟数据库查找用户
     * @param account
     * @return
     */
    public static User getUserByAccountAndPwd(String account){
        if(StringUtils.isEmpty(account))
            return null;

        // 检索用户是否存在
        return list.stream()
                .filter(user->(user.getAccount().equals(account)))
                .findAny()
                .orElse(null);
    }
}
