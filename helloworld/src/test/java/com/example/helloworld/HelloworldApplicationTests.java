package com.example.helloworld;

import com.example.helloworld.Prjo.Dog;
import com.example.helloworld.Prjo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class HelloworldApplicationTests {
    @Autowired
    public User user;
    @Resource
    public Dog dog;
    @Test
    void contextLoads() {
        System.out.print(dog);
    }

}
