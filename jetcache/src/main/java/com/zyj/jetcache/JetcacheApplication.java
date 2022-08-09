package com.zyj.jetcache;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author zyj
 */
//制定开启缓存对应的包路径名，激活Cached注解
@EnableMethodCache(basePackages = "com.zyj.jetcache")
//开启对应的CreateCache注解
@EnableCreateCacheAnnotation
@SpringBootApplication
public class JetcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(JetcacheApplication.class, args);
    }

}
