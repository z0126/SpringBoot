package com.example.webproject01.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @Author 20424
 * @Date 2020/8/30 21:02
 * @Version 1.0
 */
//templates下的页面，只能通过Controller访问
//这个需要模板引擎的支持——thymeleaf
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("msg","<h1>HELLO,WORLD!!!!</h1>");
        model.addAttribute("user", Arrays.asList("qingjiang","ssffsfsf"));//Arrays.asList("qingjiang","ssffsfsf"):将数组转化为list集合
        return "index";
    }
    @RequestMapping(value = "/user/login")
   // @ResponseBody//返回的是json数据
    public String Login(@RequestParam("username")String username, @RequestParam("password")String password,
                        Model model, HttpSession session){
        //具体的业务
        if (!StringUtils.isEmpty(username)&&"123456".equals(password)){
            session.setAttribute("user","username");
            return "redirect:/main.html";
        }else{
            //返回登陆失败
            model.addAttribute("msg","登陆失败！！！");
            return "index";
        }
    }
}
