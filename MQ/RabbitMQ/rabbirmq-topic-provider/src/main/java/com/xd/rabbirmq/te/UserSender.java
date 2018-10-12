package com.xd.rabbirmq.te;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * 消息发送者
 */
@Component
public class UserSender {


    @Autowired
    private AmqpTemplate amqpTemplate;


    //    交换器名称
    @Value("${mq.config.exchange}")
    private String exchange;




    /**
     * 消息发送方法
     *
     * @param msg
     */
    public void send(String msg) {
//        两个参数 ， 参数1 队列名称 参数2 消息
//        三个参数   参数1 交换器名称   参数2 路由键 参数3 消息
        amqpTemplate.convertAndSend(this.exchange, "user.log.info","user.log.info" + msg);
        amqpTemplate.convertAndSend(this.exchange, "user.log.debug", "user.log.debug" +msg);
        amqpTemplate.convertAndSend(this.exchange, "user.log.error","user.log.error" + msg);
        amqpTemplate.convertAndSend(this.exchange, "user.log.warn","user.log.warn" + msg);

    }

//    /**
//     * 消息发送方法
//     *
//     * @param msg
//     */
//    public void sendError(String msg) {
////        两个参数 ， 参数1 队列名称 参数2 消息
////        三个参数   参数1 交换器名称   参数2 路由键 参数3 消息
//        amqpTemplate.convertAndSend(this.exchange, this.errorRoutingKey, msg);
//
//    }
}
