package com.example.Service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

//zookeeper:服务注册与发现
@Service //将服务发布出去，在项目启动的时候自动注册到注册中心
@Component //放在容器中,使用了Dubbo后尽量不要用springframwork的@Service注解
public class TicketServiceImpl implements TicketService{

    @Override
    public String getTicket() {
        return "《狂神说Java》";
    }
}
