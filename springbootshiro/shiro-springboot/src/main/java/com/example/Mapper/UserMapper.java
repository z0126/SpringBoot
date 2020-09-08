package com.example.Mapper;

import com.example.Pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper//Mapper : 表示本类是一个 MyBatis 的 Mapper
public interface UserMapper {
    public User QueryUser(String username);
    public User QueryUserAll();
}
