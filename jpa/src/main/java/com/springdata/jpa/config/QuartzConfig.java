package com.springdata.jpa.config;


import com.springdata.jpa.quartz.QuartzDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
public class QuartzConfig {

    //    创建 jop 对象
    @Bean
    public JobDetailFactoryBean getJobDetailFactoryBean() {
        JobDetailFactoryBean factory = new JobDetailFactoryBean();
//        关联自己的job类
        factory.setJobClass(QuartzDemo.class);
        return factory;
    }
/*
    //    创建 trigger 对象
    @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();

//        关联detail对象
        simpleTriggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());


//     执行的毫秒数
        simpleTriggerFactoryBean.setRepeatInterval(2000);
//     设置重复次数
        simpleTriggerFactoryBean.setRepeatCount(10);
        return simpleTriggerFactoryBean;
    }*/

    //    创建 cron 方式 trigger 对象
    @Bean
    public CronTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();

//        关联detail对象
        factoryBean.setJobDetail(jobDetailFactoryBean.getObject());
//        设置触发时间
        factoryBean.setCronExpression("0/10 * * * * ?");
        return factoryBean;
    }

    //    创建Scheduler 对象
    @Bean
//    public SchedulerFactoryBean schedulerFactoryBean(SimpleTriggerFactoryBean simpleTriggerFactoryBean) {
    public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean, MyAdaptableLobFactory myAdaptableLobFactory) {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setTriggers(cronTriggerFactoryBean.getObject());
        schedulerFactoryBean.setJobFactory(myAdaptableLobFactory);
        return schedulerFactoryBean;
    }
}
