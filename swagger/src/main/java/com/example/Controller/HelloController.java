package com.example.Controller;

import com.example.Pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/example")
public class HelloController {
    /**
     * /error:项目默认生成的请求；
     */
    @RequestMapping(value = "/hello" ,method = RequestMethod.GET)
    public String ToHello(){
        return "Hello World!!!";
    }
    //只要我们的接口中，返回值中存在实体类，就会扫描到Swagger
    @ApiOperation("接口注释")
    @RequestMapping(value = "/getUser",method = RequestMethod.PUT)
    public User getUser(@ApiParam("用户名") String username){
        User user=new User();
        user.username=username;
        return user;
    }
}
