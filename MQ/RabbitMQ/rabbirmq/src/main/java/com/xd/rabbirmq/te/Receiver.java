package com.xd.rabbirmq.te;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * 消息接受着
 */
@Component
public class Receiver {


    /**
     * 接受消息的方法采用队列监听基质
     */
    @RabbitListener(queues = "hello-queue")
    public void process(String msg) {
            System.out.println("收到消息：" + msg);

    }
}
