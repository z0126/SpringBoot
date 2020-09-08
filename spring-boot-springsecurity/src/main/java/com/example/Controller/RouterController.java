package com.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RouterController {
    @RequestMapping(value = {"/","/index"})
    public String Goindex(){
        return "index";
    }
    @RequestMapping(value = {"/toLogin"})
    public String Gologin(){
        return "view/login";
    }
    @RequestMapping(value = {"/leavel/{id}"})//@PathVariable("id"):从Url中获取数据；@RequestParam:从数据域获取数据
    public String Goleal1(@PathVariable("id") int id){
        return "view/leavl1/"+id;
    }
    @RequestMapping(value = {"/leave2/{id}"})
    public String Goleal2(@PathVariable("id") int id){
        return "view/leavl2/"+id;
    }
    @RequestMapping(value = {"/leave3/{id}"})
    public String Goleal3(@PathVariable("id") int id){
        return "view/leavl3/"+id;
    }
}
