package com.zyj.springcloudswagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动后访问swagger地址http://localhost:8881/swagger-ui.html即可
 */
@SpringBootApplication
public class SpringcloudSwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudSwaggerApplication.class, args);
    }

}
