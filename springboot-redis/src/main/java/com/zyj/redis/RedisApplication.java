package com.zyj.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @EnableCaching开启redis缓存，如果想在方法上实现先找redis再找数据库可开
 */
@SpringBootApplication
@EnableCaching
public class RedisApplication {

    public static void main(String[] args){
        SpringApplication.run(RedisApplication.class, args);
    }
}
