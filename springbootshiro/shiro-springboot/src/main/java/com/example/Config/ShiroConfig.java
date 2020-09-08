package com.example.Config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration//令此类成为一个配置类
public class ShiroConfig {
    //shiro中都叫过滤器

    //ShiroFilterFactoryBean 3       [创建shiro时必须存在的类]
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro的内置过滤器
        /**
         * anon:无需认证就可以访问
         * authc:必须认证才可以访问
         * user: 必须拥有“记住我”才可以访问
         * perms:拥有某个资源的权限才能访问
         * role:拥有某个角色权限才能访问
         */
        Map<String, String> filters = new LinkedHashMap();
        /**
         * 方法一
         *filters.put("/user/add","authc");
         *filters.put("/user/update","authc");
         */
        //方法二
        filters.put("/user/add","perms[user:add]");//必须是user用户且有add权限；401错误未授权，正常会跳到未授权页面
        filters.put("/user/*","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filters);
        //没有登录，设置前往登录的页面
        shiroFilterFactoryBean.setLoginUrl("/ToLogin");
        shiroFilterFactoryBean.setUnauthorizedUrl("/noauthor");
        return shiroFilterFactoryBean;
    }


    /**
     *     DefaultWebSecurityManager  2          @Qualifier的用处 :可以对于一个接口，多个实现类，指定具体注入哪个实现类到这个接口类
     *     [创建shiro时必须存在的类]
     */
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRemal") UserRemal userRemal){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        //关联Remal
        securityManager.setRealm(userRemal);
        return securityManager;
    }



    //创建 remal对象 ，需要自定义 1    [创建shiro时必须存在的类]
    @Bean
    public UserRemal userRemal(){
        UserRemal userRemal=new UserRemal();
        //注入密码加密
        userRemal.setCredentialsMatcher(hashedCredentialsMatcher());
        return userRemal;
    }



    //整合ShiroDialect:用来整合shiro 和 thymeleaf,由于没有spring的配置文件所以如此存放
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }


    /**
     * 当需要密码加密时才存在
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        //可以加密，  MD5：不可逆  MD5盐值加密在MD5的记住上再加上username值
        //CredentialsMatcher:凭证匹配器，会自动将从前台获取的密码转换为MD5加密的形式，因此要对数据库的密码吗进行改变
        HashedCredentialsMatcher hashedCredentialsMatcher=new HashedCredentialsMatcher();
        //加密方式
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        //加密次数
        hashedCredentialsMatcher.setHashIterations(1024);
        return  hashedCredentialsMatcher;
    }
}
