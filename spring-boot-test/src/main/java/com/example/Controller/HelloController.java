package com.example.Controller;

import com.example.Service.AsnyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    AsnyService asnyService;
    @RequestMapping("/hello")
    public Object ToHello(){
        asnyService.hello();//延迟3秒
        return "OK!!!";
    }
}
