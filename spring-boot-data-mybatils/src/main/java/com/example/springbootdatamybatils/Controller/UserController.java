package com.example.springbootdatamybatils.Controller;

import com.example.springbootdatamybatils.Mapper.Usermapper;
import com.example.springbootdatamybatils.Prjo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    Usermapper usermapper;
    @GetMapping("/SelectAll")
    public List<User> querylist(){
        return usermapper.SelectAll();
    }
}
