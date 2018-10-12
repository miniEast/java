package com.xd.rabbirmq.te;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 消息发送者
 */
@Component
public class Sender {


    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 消息发送方法
     *
     * @param msg
     */
    public void send(String msg) {
//        两个参数 ， 参数1 队列名称 参数2 消息
        amqpTemplate.convertAndSend("hello-queue",msg);

    }
}
