package com.zyj.springcloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 路由信息需要自己去nacos加
 */
@SpringBootApplication
public class SpringcloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudGatewayApplication.class, args);
	}

}
