package com.xiao.security;

import com.xiao.entity.Authority;
import com.xiao.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class SecurityUserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.info("登录用户账号为：{}", s);

        // 查询用户信息
        User user = User.getUserByAccountAndPwd(s);
        if (user == null) {//抛出错误，用户不存在
            throw new UsernameNotFoundException("用户名 " + s + "不存在");
        }
        log.info(user.toString());

        //获取用户权限
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<Authority> authorities = Authority.getUserAuthority(user.getId());
        authorities.forEach(authority -> {
            grantedAuthorities.add(authority);
        });

        SecurityUser securityUser = new SecurityUser(user.getAccount(), user.getPassword());
        securityUser.setAuthorities(grantedAuthorities);
        return securityUser;
    }
}
