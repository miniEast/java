package com.springdata.jpa.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;


@Component("MyAdaptableLobFactory")
public class MyAdaptableLobFactory extends AdaptableJobFactory {

    //可以将对象放入 springIOC容器中并完成注入
    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object jobInstance = super.createJobInstance(bundle);
//        手动吧对象实例化到spring容器中
        autowireCapableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }


}
