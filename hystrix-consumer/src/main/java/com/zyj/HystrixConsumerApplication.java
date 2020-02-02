package com.zyj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableCircuitBreaker
public class HystrixConsumerApplication {
	@Autowired
	private HystrixService hystrixService;

	public static void main(String[] args) {
		SpringApplication.run(HystrixConsumerApplication.class, args);
	}

	@RequestMapping("/toSay")
	public String toSay(){
		return hystrixService.callHystrixProvider();
	}

}
