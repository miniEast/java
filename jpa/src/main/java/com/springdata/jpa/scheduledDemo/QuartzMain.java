package com.springdata.jpa.scheduledDemo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.TriggerBuilder.newTrigger;

public class QuartzMain {
    public static void main(String[] a) throws Exception {
//        创建jop 做设么事
        JobDetail jop = JobBuilder.newJob(QuartzDemo.class).build();

/**
 * 简单的trigger 触发时间 ，通过 Quartz 提供的方法 完成方法重复调用
 */
//        创建 tigger 对象，什么时候做
//      简单的 tirrger
//        Trigger trigger =  TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever()).build();


//        复杂的tirgger
        Trigger trigger =  TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")).build();

//        创建 scheduled ，在什么时候做设么事

        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
        defaultScheduler.scheduleJob(jop,trigger);
        defaultScheduler.start();
    }
}
