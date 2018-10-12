package com.example.demo;

import com.example.demo.filter.SecandFilter;
import com.example.demo.listener.SecandListener;
import com.example.demo.servlet.SecandServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

//禁用自动配置
@SpringBootApplication(exclude = {
        RedisAutoConfiguration.class,
        RedisRepositoriesAutoConfiguration.class
})
@ServletComponentScan //扫描webservlet 注解 并且将该类实例化
@MapperScan(value = "com.example.demo.mapper") //扫描mapper接口
@EnableCaching  //启动缓存
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    //  组件启动servlet
    @Bean
    public ServletRegistrationBean getservletRegisterBeen() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new SecandServlet());
        bean.addUrlMappings("/secand");
        return bean;
    }

    //    注册过滤器
    @Bean
    public FilterRegistrationBean getFilterRegisterBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new SecandFilter());
        filterRegistrationBean.addUrlPatterns("/secand");
        return filterRegistrationBean;
    }

    //    注册监听器
    @Bean
    public ServletListenerRegistrationBean<SecandListener> getServletListenerRegistrationBean() {
        ServletListenerRegistrationBean<SecandListener> secandListenerServletListenerRegistrationBean = new ServletListenerRegistrationBean<>(new SecandListener());
        return secandListenerServletListenerRegistrationBean;
    }
}
