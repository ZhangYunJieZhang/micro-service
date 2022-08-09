package com.zyj.rabbitmqproducer;

import com.zyj.rabbitmqproducer.sender.RabbitSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyj
 */
@SpringBootApplication
@RestController
public class RabbitmqProducerApplication {

    @Autowired
    RabbitSender sender;

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProducerApplication.class, args);
    }

    @GetMapping("/testsend")
    public void testSend() {
        try{
            Map<String, Object> properties = new HashMap<>();
            properties.put("number", "12345");
            properties.put("send_time", System.currentTimeMillis());
            sender.send("Hello RabbitMQ For Spring Boot!", properties);
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println("测试发送消息失败");
        }

    }

}
