package com.example.Service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    /**
     *  30  15    10        * *   ?:每天10点15分30秒执行一次
     *  30  0/5   10,18     * *   ?:每天10点和18点，每个5分钟执行一次
     *  0   15    10        ? *  1-6:每个月的周一到周六的10点15分执行一次
     */
    //秒   分   时     日   月   周几
    //0 * * * * MON-FRI
    //注意cron表达式的用法；
    @Scheduled(cron = "40/5 7 18 * * ? ")
    public void hello(){
        System.out.println("hello.....");
    }
}
