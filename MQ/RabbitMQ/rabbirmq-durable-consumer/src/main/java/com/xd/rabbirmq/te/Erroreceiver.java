package com.xd.rabbirmq.te;


import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;


/**
 * 消息接受着
 * <p>
 * RabbitListener : bindings 绑定队列
 *
 * @QueueBinding 绑定队列详细名字
 * @Queue value        配置队列名称
 * autoDelete  是否是可删除的临时队列  当客户端断开连接是否自动删除队列  true 删除  false 不删除
 * <p>
 * exchange   配置交换器
 * @Exchange value  交换机名称
 *           type   交换器类型
 *            autoDelete  当所有绑定队列都不在使用时是否自动删除队列 true 删除  false 不删除
 *
 *
 */
@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue.error}", autoDelete = "false"),
                exchange = @Exchange(value = "${mq.config.exchange}", type = ExchangeTypes.DIRECT),
                key = "${mq.config.queue.error.routing}"
        )
)
public class Erroreceiver {


    /**
     * 接受消息的方法采用队列监听基质
     */
    @RabbitHandler
    public void process(String msg) {
        System.out.println("ERROR 收到消息 ：" + msg);
    }
}
