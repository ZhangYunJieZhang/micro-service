package com.zyj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceApplication {

	/**
	 * 不是服务提供者，启动后当作注册中心，如果想把自己也注册进去，配置文件两个false要改成true
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceApplication.class, args);
	}

}
