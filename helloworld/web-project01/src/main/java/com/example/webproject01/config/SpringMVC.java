package com.example.webproject01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

//扩展springmvc,官方建议的做法
//如果想diy一些定制化的内容，只要写这个组件,然后将它交给spring boot，spring boot会帮我们自动装配
//此类将自定义的相关Resolver加入到spring容器中，Resolver的编写可以以其他类进行
@Configuration
public class SpringMVC implements WebMvcConfigurer {
    /*//ViewResolver：实现了视图解析器接口的类，就可以看作视图解析器
    public ViewResolver myviewResolver(){
        return new MyVtewResolver();
    }
    //自定义了一个自己的视图解析器myViewResolver
    public static class MyVtewResolver implements ViewResolver{
        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }*/

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {//试图控制器，此方法比Controller进行页面跳转更快
        registry.addViewController("/").setViewName("index.html");
        registry.addViewController("/index.html").setViewName("index.html");
        registry.addViewController("/main.html").setViewName("success.html");
    }
    //将自定义的国际化加入到容器中
    @Bean
    public LocaleResolver localeResolver(){
        return new myLocalResolver();
    }
    //将拦截器加入到bean进行注册

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerIntercepter()).addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/user/login","/css/**","/js/**","/img/**");
    }
}
