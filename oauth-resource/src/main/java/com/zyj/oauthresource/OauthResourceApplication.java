package com.zyj.oauthresource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OauthResourceApplication {

    /**
     * post校验token是否有效
     * http://localhost:8080/oauth/check_token?token=ea2c1b1e-5541-4018-8728-07f1ac87e9e8
     *
     * post 授权携带token和头携带appid和appsecret请求接口
     * http://localhost:8081/payService
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(OauthResourceApplication.class, args);
    }

}
