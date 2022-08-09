package com.zyj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

	@RestController
	class ServiceInstanceRestController {

		/**
		 * discoveryclient用于发现注册中心服务
		 */
		@Autowired
		private DiscoveryClient discoveryClient;

		/**
		 * 本例没有写服务提供者，直接试下是否可以从注册中心获取服务，如果想调用服务可以用restTemplate或者feign
		 * 如：String greeting = restTemplate.getForObject("http://localhost:6666/greeting",String.class);
		 * @param applicationName
		 * @return
		 */
		@RequestMapping("/service-instances/{applicationName}")
		public List<ServiceInstance> serviceInstancesByApplicationName(
				@PathVariable String applicationName) {
			return this.discoveryClient.getInstances(applicationName);
		}
	}

}
