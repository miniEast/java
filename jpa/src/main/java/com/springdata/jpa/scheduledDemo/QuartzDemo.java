package com.springdata.jpa.scheduledDemo;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;


/**
 * 定义任务类
 */
public class QuartzDemo implements Job {

    /**
     * 任务被触发时执行的方法
     *
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("execute Quartz 任务执行了" + new Date());
    }
}
