package com.zyj.zuulprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ZuulProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulProviderApplication.class, args);
	}

	@RequestMapping("/play")
	public String play(){
		return "this is zuul provider";
	}

}
