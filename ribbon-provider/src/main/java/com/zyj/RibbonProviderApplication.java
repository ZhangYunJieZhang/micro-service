package com.zyj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class RibbonProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonProviderApplication.class, args);
	}

	@RequestMapping("/greeting")
	public String greeting(){
		List<String> greetings = Arrays.asList("hello1","hello2","hello3");
		Random random = new Random();
		return greetings.get(random.nextInt(3));
	}

	@RequestMapping("/")
	public String home(){
		return "hi";
	}

}
