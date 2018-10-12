package com.xd.rabbirmq.te;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * 消息发送者
 */
@Component
public class OrderSender {


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
        amqpTemplate.convertAndSend(this.exchange, "order.log.info", "order.log.info  " + msg);
        amqpTemplate.convertAndSend(this.exchange, "order.log.debug", "order.log.debug" + msg);
        amqpTemplate.convertAndSend(this.exchange, "order.log.error", "order.log.error" + msg);
        amqpTemplate.convertAndSend(this.exchange, "order.log.warn", "order .log.warn" + msg);

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
