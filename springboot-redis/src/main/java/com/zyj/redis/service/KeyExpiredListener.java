package com.zyj.redis.service;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

/**
 * redis过期回调类
 */
@Component
public class KeyExpiredListener extends KeyExpirationEventMessageListener {

    public KeyExpiredListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    /**
     * key过期会执行这个方法,一般key自己加前缀再来过期时判断是否是需要处理的业务类型（也可以用redis库区分）
     * @param message
     * @param pattern
     *
     * 这个key过期啦==========================:111
     * [B@5977f679
     * [B@57b01327
     * __keyevent@*__:expired
     *
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println("这个key过期啦==========================:" + message.toString());
        System.out.println(message.getBody());
        System.out.println(message.getChannel());
        System.out.println(new String(pattern));
        //判断前缀是否是我们的业务

        //查询数据库

        //修改状态
        super.onMessage(message, pattern);
    }
}
