package com.xd.rabbirmq.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {


    /**
     * 创建队列
     *
     * @return
     */
    @Bean
    public Queue queue() {
        return new Queue("hello-queue");
    }
}
