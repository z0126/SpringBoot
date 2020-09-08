package com.example.Service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsnyService {
    //告诉spring这是一个异步的方法
    @Async
    public void hello(){
        try {
            Thread.sleep(3000);//休眠3秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("业务进行中....");
    }
}
