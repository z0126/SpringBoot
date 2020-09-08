package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringbootRedisApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;//可以链式编写
    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("mykey","关住了吗");
        System.out.print(redisTemplate.opsForValue().get("mykey"));
    }

}
