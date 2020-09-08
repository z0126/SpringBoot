package com.example.webproject01.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 实现了LocalResolver中的部分方法，原实现类仍然加载
 * @Author 20424
 * @Date 2020/9/1 23:54
 * @Version 1.0
 */
public class myLocalResolver implements LocaleResolver {
    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String langage=httpServletRequest.getParameter("l");
        Locale defaultLocale = Locale.getDefault();//如果不存在就是用默认的
        if (!StringUtils.isEmpty(langage)){
            //zh_CN
            String spit[]=langage.split("_");//以“_”为间隔进行分割
            //国家，地区
            defaultLocale=new Locale(spit[0],spit[1]);
        }
        return defaultLocale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
