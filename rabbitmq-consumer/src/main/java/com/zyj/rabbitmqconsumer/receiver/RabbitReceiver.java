package com.zyj.rabbitmqconsumer.receiver;

import com.rabbitmq.client.Channel;
import com.zyj.rabbitmqconsumer.entity.Order;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author zyj
 */
@Component
public class RabbitReceiver {


    //这些配置可以放配置文件或者注册中心
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "queue-1",
                    durable="true"),
            exchange = @Exchange(value = "exchang-1",
                    durable="true",
                    type= "topic",
                    ignoreDeclarationExceptions = "true"),
            key = "springboot.*"
    )
    )

    /**
     * 基本消费方法
     */
    @RabbitHandler
    public void onMessage(Message message, Channel channel) throws Exception {
        System.err.println("--------------------------------------");
        System.err.println("消费端Payload: " + message.getPayload());
        Long deliveryTag = (Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        //手工ACK,获取deliveryTag
        channel.basicAck(deliveryTag, false);
    }

    /**
     * 优化后的消费方法
     * @Payload：指定具体的消息体Body
     * @Headers: 获取Headers
     * @param order
     * @param channel
     * @param headers
     * @throws Exception
     */
    @RabbitHandler
    public void onOrderMessage(@Payload Order order,
                               Channel channel,
                               @Headers Map<String, Object> headers) throws Exception {
        System.err.println("--------------------------------------");
        System.err.println("消费端order: " + order.getId());
        Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
        //手工ACK
        channel.basicAck(deliveryTag, false);
    }
}
