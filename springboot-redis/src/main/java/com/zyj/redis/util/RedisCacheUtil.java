package com.zyj.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisCacheUtil {

    /**
     *测试转成json字符串储存
     */
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 测试直接利用redis内部机制自动转二进制储存，
     * 用@Autowired会找不到bean，一是没有托管在spring，二是Autowired默认byType找不到，Resource则byName
     * RedisTemplate只支持两种泛型<String, String>和<Object, Object>
     * 所以可以泛型写成<String, String>或者<Object, Object>，使用@Autowired注入
     * 也可以@Resource注解默认使用byName方式，如果byName方式注入失败，会自动使用byType方式注入
     *
     */
    @Resource
    RedisTemplate<String,Object> redisTemplate;

    public void setValue(String key, String value){
        stringRedisTemplate.opsForValue().set(key,value);
        stringRedisTemplate.expire(key, 1000, TimeUnit.SECONDS);
    }

    public String getValue(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    public void setObject(String key, Object value){
        redisTemplate.opsForValue().set(key, value);
    }

    public Object getObject(String key){
        return redisTemplate.opsForValue().get(key);
    }
}
