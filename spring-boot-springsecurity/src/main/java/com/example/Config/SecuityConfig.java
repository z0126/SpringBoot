package com.example.Config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecuityConfig extends WebSecurityConfigurerAdapter {
    //认证
    //inMemoryAuthentication:内存认证;jdbcAuthentication():数据库认证 and():角色拼接
    //spring boot2.1.X可以直接使用
    //密码编码：PasswordEncoder；  PasswordEncoder结尾的类都是写好的认证规则
    //在Spring Security 5.0+  新增了很多的加密方式
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("kuangsheng").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2")
                .and()
                .withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("vip3");
    }

    //链式编程
    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问authorizeRequests():认证请求 antMatchers():访问地址    permitAll()：所有人访问
        //hasRole(c):只有可以访问
        //请求授权的功能
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/leave1/**").hasRole("vip1")
                .antMatchers("/leave2/**").hasRole("vip2")
                .antMatchers("/leave3/**").hasRole("vip3");
        // 开启自动配置的登录功能
        // /login 请求来到登录页
        // /login?error 重定向到这里表示登录失败
        /**
         *  loginPage("/login"):登陆页面   loginProcessingUrl("/login"):处理请求页面
         *  usernameParameter("username"):设置登录用户名name
         *  passwordParameter("pwd"):设置密码name
          */
        http.formLogin().loginPage("/toLogin")
                .usernameParameter("user")
                .passwordParameter("pwd")
                .loginProcessingUrl("/login");//定制登录页
        //注销,跳转至首页
        http.logout().logoutSuccessUrl("/");
        //防止网站工具： get/Post
        http.csrf().disable();//关闭CSRF（防止跨站脚本伪造），退出失败可能存在的原因
        //开启记住我  cookie:记住时间：14天  rememberMeParameter("remember"):自定义
        http.rememberMe().rememberMeParameter("remember");
    }

}
