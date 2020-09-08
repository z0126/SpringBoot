package com.example.Service;

import com.example.Pojo.User;

public interface UserService {
    //业务简单情况下可以省略Service层，此层如果为类则可以直接加上@Service注解
    public User QueryUser(String username);
}
