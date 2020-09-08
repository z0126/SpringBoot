package com.example.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration//就等价于@Component,会将此类配置到配置里面，会令此类被spring管理
@EnableSwagger2//开启Swagger2
public class SwaggerConfig {
    /**
     * 多个Docket的配置
     */
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("group1");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("group2");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("group3");
    }
    //配置了Swagger的Docket的bean的实例
    @Bean //配置docket以配置Swagger具体参数
    public Docket docket(Environment environment) {

        // 设置要显示swagger的环境
        Profiles of = Profiles.of("dev", "test");//String...:表示可变长数组,当不是dev时无法启动
        /**
         * 判断当前是否处于该环境
         * 通过 enable() 接收此参数判断是否要显示
         */
        boolean b = environment.acceptsProfiles(of);//Profiles:可以传递多个，因此此处传递一个足矣

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("Swagger")
                .enable(b)//不自动启动
                .select()//select()必须与build()配合使用二者之间只能有apis()和paths()方法
                .apis(RequestHandlerSelectors.basePackage("com.example.Controller"))//RequestHandlerSelectors:配置要扫描接口的方式
                // 1.any():扫描全部      2.none():都不扫描      3.basePackage()：指定要扫描的包,一般用词
                // 4.withClassAnnotation():扫描类上的注解,是一个注解的反射对象     5.withMethodAnnotation():扫描方法上的注解

                .paths(PathSelectors.ant("/example/**"))//过滤什么路路径,之扫描带有“kuang”的接口
                //1.any():扫描全部      2.none():都不扫描
                //3.ant():指定路径      4.regex():正则式
                .build();//使用build()后就只有apis和path方法
    }
    //配置Swagger信息=apiInfo
    //配置文档信息
    private ApiInfo apiInfo() {
        //无set方法，因此只能通过构造器赋值
        Contact contact = new Contact("秦将", "http://xxx.xxx.com/联系人访问链接", "联系人邮箱");
        return new ApiInfo(
                "Swagger学习", // 标题
                "学习演示如何配置Swagger", // 描述
                "v1.0", // 版本
                "http://terms.service.url/组织链接", // 组织链接
                contact, // 联系人信息
                "Apach 2.0 许可", // 许可
                "许可链接", // 许可连接
                new ArrayList<>()// 扩展
        );
    }
}
