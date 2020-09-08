package com.example.Service;

import com.example.Mapper.UserMapper;
import com.example.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    //通过调用数据层的方法，实现对数据库的操作
    @Autowired
    UserMapper userMapper;
    public User QueryUser(String username){
        return userMapper.QueryUser(username);
    };
}
