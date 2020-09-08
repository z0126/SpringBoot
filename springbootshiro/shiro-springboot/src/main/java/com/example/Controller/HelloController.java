package com.example.Controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

@Controller
public class HelloController {
    @RequestMapping({"/","/index"})
    public String ToIndex(Model model){
        model.addAttribute("msg","helloWold");
        return "index";
    }
    @RequestMapping("/user/add")
    public String Adduser(){
        return "user/adduser";
    }
    @RequestMapping("/user/update")
    public String UpdateUser(){
        return "user/update";
    }
    @RequestMapping("/ToLogin")
    public String ToLogin(){
        return "login";
    }
    @RequestMapping(value = "/login")
    public String login(@PathParam(value = "username") String username, @PathParam(value = "password") String password, Model model){
        //获取当前用户@PathParam（推荐）:获取request域中的值 @PathVariable：url中获取在'?之前的内容',此方式允许在请求名后添加数据
        Subject subject= SecurityUtils.getSubject();
        //固定令牌加密    token:是全局的数据共享的
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        try {
            subject.login(token);//登陆令牌
            return "index";
        }catch (UnknownAccountException uae) {
            model.addAttribute("msg","用户不存在");//用户不存在
            return "login";
        } catch (IncorrectCredentialsException ice) {
            model.addAttribute("msg","密码不对");//密码不对
            return "login";
        } catch (LockedAccountException lae) {
            model.addAttribute("msg","用户已经锁定");//用户被锁定了如：5此密码都不对
            return "login";
        }
        // ... catch more exceptions here (maybe custom ones specific to your application?
        catch (AuthenticationException ae) {
            //认证异常
            return "login";
        }
    }
    @RequestMapping(value = "/noauthor")
    @ResponseBody//返回的是json数据
    public String unauthorized(){
        return "未授权";
    }
    @RequestMapping(value = "/logout")
    public String logoutLogout(){
        Subject subject=SecurityUtils.getSubject();
        subject.logout();//退出操作
        return "index";
    }
}
