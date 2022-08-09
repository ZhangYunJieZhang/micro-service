package com.zyj.redis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * 加载redis监听类到spring
 */
@Configuration
public class RedisConfiguration {

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Bean
    ChannelTopic channelTopic(){
        return new ChannelTopic("__keyevent@0__:expired");//选择0号数据库，默认全部__keyevent@*__:expired
    }

    /**
     * 也可以注入redisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory)这个重载方法，省得获取factory
     * @return
     */
    @Bean
    RedisMessageListenerContainer redisMessageListenerContainer(){
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
        return redisMessageListenerContainer;
    }
}
