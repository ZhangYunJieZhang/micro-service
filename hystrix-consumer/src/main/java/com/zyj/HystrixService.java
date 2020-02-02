package com.zyj;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.net.URI;

@Service
public class HystrixService {

    @HystrixCommand(fallbackMethod = "failureCallBack")
    public String callHystrixProvider(){
        RestTemplate restTemplate = new RestTemplate();
        URI uri = URI.create("http://localhost:7600/sayHello");
        return restTemplate.getForObject(uri,String.class);
    }

    public String failureCallBack(){
        return "hello,this is hystrix failure callback";
    }
}
