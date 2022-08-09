package com.zyj.rabbitmqproducer.sender;

import com.zyj.rabbitmqproducer.sender.entity.Order;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class RabbitSender {

    //自动注入RabbitTemplate模板类
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //回调函数: confirm确认（实现一个监听器用于监听Broker端给我们返回的确认请求），这里可以用threadlocal变量记录重试次数,保证消息不丢失，实在失败的再用job同步
    final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            System.err.println("发送失败返回的消息correlationData: " + correlationData);
            System.err.println("ack: " + ack);
            if(!ack){
                //可以进行日志记录、异常处理、补偿处理等
                String message = correlationData.getId();
                System.err.println("异常处理....");
            }else {
                //更新数据库，可靠性投递机制
                System.err.println("ack success....");
            }
        }
    };

    //回调函数: return返回（保证消息对Broker端是可达的，如果出现路由键不可达的情况，则使用监听器对不可达的消息进行后续的处理，保证消息的路由成功）
    final RabbitTemplate.ReturnCallback returnCallback = new RabbitTemplate.ReturnCallback() {
        @Override
        public void returnedMessage(org.springframework.amqp.core.Message message, int replyCode, String replyText,
                                    String exchange, String routingKey) {
            System.err.println("return exchange: " + exchange + ", routingKey: "
                    + routingKey + ", replyCode: " + replyCode + ", replyText: " + replyText);
        }
    };

    //发送消息方法调用: 构建Message消息
    public void send(Object message, Map<String, Object> properties) throws Exception {
        MessageHeaders mhs = new MessageHeaders(properties);
        Message msg = MessageBuilder.createMessage(message, mhs);
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.setReturnCallback(returnCallback);
        //id + 时间戳 全局唯一  用于ack保证唯一一条消息,这边做测试写死一个。但是在做补偿策略的时候，必须保证这是全局唯一的消息
        CorrelationData correlationData = new CorrelationData("1234567890");
        rabbitTemplate.convertAndSend("exchang-1", "springboot.abc", msg, correlationData);
    }

    //发送消息方法调用: 构建自定义对象消息.生产消息还有很多重载方法,会自动根据入参选择进入的方法
    public void sendOrder(Order order) throws Exception {
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.setReturnCallback(returnCallback);
        //id + 时间戳 全局唯一，可以放order的id，或者这个消息体，失败的时候这个对象可以拿到进行重试
        CorrelationData correlationData = new CorrelationData("0987654321");
        rabbitTemplate.convertAndSend("exchang-1", "springboot.def", order, correlationData);
    }

}