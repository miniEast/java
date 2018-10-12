package com.springdata.jpa.scheduledDemo;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduledDemo {


    /**
     * 定时任务
     * cron 表达式 定时任务触发时间字符串表达式
     */

//    每到3秒的时候执行一次 一分钟一次
    @Scheduled(cron = "3 * * * * ?")
    public void cheduledmoth() {
        System.out.println("定时器任务除发了" + new Date());
    }
}
