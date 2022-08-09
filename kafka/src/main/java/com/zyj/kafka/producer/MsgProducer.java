package com.zyj.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@Slf4j
public class MsgProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(String message){
        log.info("生产者开始发送消息:{}" , message);
        //key固定写死达不到分区存放的意义，这里随便用作测试，实际应该根据业务来

        ListenableFuture listenableFuture =  kafkaTemplate.send("testTopic","key1",message);
        listenableFuture.addCallback(new ListenableFutureCallback() {
            @Override
            public void onFailure(Throwable throwable) {
                log.info("消息发送失败:{}" , throwable.getMessage());
            }

            @Override
            public void onSuccess(Object o) {
                log.info("消息发送成功:{}" , o.toString());
            }
        });
    }
}
