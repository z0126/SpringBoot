package com.example.helloworld.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 20424
 * @Date 2020/8/29 16:25
 * @Version 1.0
 */
@RestController//@RestController=@ResponseBody+@Controller  返回结果为Json字符串
public class UserController {

    @RequestMapping("/hello.do")
    public String HelloWord(){
        return "Hello World!!!";
    }
}
