package com.zyj;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试nacos当配置中心
 */
@SpringBootApplication
@RestController
@NacosPropertySource(dataId = "nacos-config",autoRefreshed = true)
public class NacosConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosConfigApplication.class, args);
	}

	/**
	 * 通过@NacosValue获取nacos配置中心的值，可以登录nacos后台进行修改再访问，能看到123值变了
	 */
	@NacosValue(value = "${nacos.test.propertie:123}",autoRefreshed = true)
	private String nacosValue;

	@RequestMapping("/getNacosValue")
	public String getNacosValue(){
		return nacosValue;
	}

}
