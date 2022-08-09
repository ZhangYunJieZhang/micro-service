package com.zyj.alldemo.strategy;

import org.springframework.stereotype.Component;

/**
 * 发送短信策略接口实现
 */
@Component
public class TengxunyunMsgStrategy implements MessageStrategy {

    @Override
    public void sendMsg() {
        System.out.println("调用腾讯云渠道发送短信");
    }
}
