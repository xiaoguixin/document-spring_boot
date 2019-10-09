package com.xiao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 权限信息
 */
@Data
@AllArgsConstructor
public class Authority implements GrantedAuthority {

    private Long id;
    private Long userId;
    private String authority;

    // 权限配置
    private final static List<Authority> list;

    static {
        list = new ArrayList<>();
        list.add(new Authority(1L, 1L, "user/select"));
        list.add(new Authority(1L, 1L, "user/add"));
        list.add(new Authority(1L, 1L, "user/edit"));
        list.add(new Authority(1L, 1L, "user/del"));
    }

    /**
     * 模拟获取用户权限
     *
     * @param userId
     * @return
     */
    public static List<Authority> getUserAuthority(Long userId) {
        if (userId == null || userId.intValue() <= 0) {
            return null;
        }

        // 检索用户权限
        return list.stream()
                .filter(authority -> (authority.userId == userId))
                .collect(toList());
    }
}
