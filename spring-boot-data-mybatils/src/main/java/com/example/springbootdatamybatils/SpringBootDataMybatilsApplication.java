package com.example.springbootdatamybatils;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.example.springbootdatamybatils.Mapper")//扫描Mapper包
public class SpringBootDataMybatilsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataMybatilsApplication.class, args);
    }

}
