package com.xiao.config;

import com.xiao.security.SecurityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Security配置文件
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityUserService securityUserService;

    /**
     * 验证用户登录和授权操作
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityUserService).passwordEncoder(new BCryptPasswordEncoder());

        // 使用内存验证用户
        /*BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(bCryptPasswordEncoder.encode("123456")).roles("user");*/
    }

    /**
     * 设置访问规则
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()//跨站
                .disable()//关闭跨站检测
                .authorizeRequests()//验证策略策略链
                .antMatchers("/public/**").permitAll()//无需验证路径
                .antMatchers("/login").permitAll()
                //角色类似，hasRole(),hasAnyRole()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login") //未登录跳转页面,设置了authenticationentrypoint后无需设置未登录跳转页面
                .loginProcessingUrl("/user/login")//处理登录post请求接口，无需自己实现
                .successForwardUrl("/index")//登录成功转发接口
                .failureForwardUrl("/login")//登录失败转发接口
                .usernameParameter("account") //修改用户名的表单name，默认为username
                .passwordParameter("password")//修改密码的表单name，默认为password
                .and()
                .logout()//自定义登出
                .logoutUrl("/logout") //自定义登出api，无需自己实现
                .logoutSuccessUrl("/login");
    }
}
