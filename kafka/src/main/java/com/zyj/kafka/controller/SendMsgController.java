package com.zyj.kafka.controller;

import com.zyj.kafka.producer.MsgProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试发送消息入口
 */
@RestController
public class SendMsgController {

    @Autowired
    MsgProducer msgProducer;

    @GetMapping("/message/send")
    public boolean sendMsg(@RequestParam String message){
        msgProducer.send(message);
        return true;
    }
}
