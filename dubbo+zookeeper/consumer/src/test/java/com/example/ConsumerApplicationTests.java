package com.example;

import com.example.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
class ConsumerApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {

        userService.bugTicket();

    }

}
