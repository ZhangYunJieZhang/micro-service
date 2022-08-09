package com.zyj.alldemo.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 策略测试类
 */
@RestController
public class TestStrategy {

    @Autowired
    MsgStrategyContext msgStrategyContext;

    @GetMapping("/sendMsg")
    void sendMsg(String strategyId){
        msgStrategyContext.getMsgStrategy(strategyId).sendMsg();
    }

    @GetMapping("/pay")
    void pay(){
        //策略表设计好一点，这里的支付策略不管用的支付宝，微信，银联都可以跟上面的发短信公用一张策略表，用type区分就行，如果有禁用的渠道在加个status字段
    }
}
