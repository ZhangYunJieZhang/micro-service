package com.zyj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class RibbonConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonConsumerApplication.class, args);
	}


	/**
	 * rest想要通过别名方式调用服务必须开启负载均衡功能，因为底层依赖于ribbon
	 * rest是spring-web包提供的，底层httpclient，feign是springcloud包提供的
	 * @return
	 */
	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	/**
	 * ribbon是本地负载均衡，获取到远程服务地址后，缓存在本地（jvm），再采用算法去进行本地rpc远程调用，是客户端负载，如dubbo，springcloud
	 * nignx是服务器端负载均衡，如tomcat等
	 * ribbon负载均衡就是总请求数%服务器总数，来获取服务器下标，对应转发到哪台服务器，也可以自己写，只是已经封装了
	 * @param name
	 * @return
	 */
	@RequestMapping("/hi")
	public String hi(@RequestParam(value="name" , defaultValue = "SpringCloud") String name){
		//直连方式
		//String greeting = restTemplate.getForObject("http://localhost:6666/greeting",String.class);
		//通过ribbon和eureka负载均衡
		String greeting = restTemplate.getForObject("http://ribbon-provider/greeting",String.class);
		return String.format("%s , %s!",greeting , name);
	}

}
