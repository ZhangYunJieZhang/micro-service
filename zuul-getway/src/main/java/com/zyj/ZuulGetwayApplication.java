package com.zyj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class ZuulGetwayApplication {

    /**
     * 添加zuul过滤器
     * @return
     */
	@Bean
	MyZuulFilter myZuulFilter(){
		return new MyZuulFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(ZuulGetwayApplication.class, args);
	}

}
