package com.example.springbootdatamybatils.Mapper;

import com.example.springbootdatamybatils.Prjo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper//表示本类是一个mybatils的mapper类   或者在主类上使用@MapperScan("com.example.springbootdatamybatils.Mapper")//扫描Mapper包
@Component
public interface Usermapper {
    //public static final  int age=18;//接口中，除了抽象方法之外，还可以含有常量
    List<User> SelectAll();
    User queryById(String username);
    int addUser(User user);
    int updateUser(User user);
    int delect(String username);
}
