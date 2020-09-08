package com.example.helloworld.Prjo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @Author 20424
 * @Date 2020/8/29 17:57
 * @Version 1.0
 */
@Component//定义为组件，让spring 管理
//@PropertySource(value = "classpath:qingjiang.properties")//加载指定的配置文件,绑定配置文件中的值
@ConfigurationProperties(prefix = "users")
@Validated//数据校验注解，由此注解开启校验
public class User {
    //SPEL表达式取出配置文件中的值,读取外部的文件
    //@Value("${name}")
    private String name;
    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
