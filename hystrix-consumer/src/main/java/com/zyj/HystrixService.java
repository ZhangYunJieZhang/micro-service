package com.zyj;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.net.URI;

/**
 * 雪崩效应
 * 默认情况下，tomcat只有一个线程池去处理请求，在高并发情况下，当线程池默认50个线程被用完就会导致其他请求一直在等待，无法访问
 * 想要测试高并发请求可以用Jmeter压测工具
 *
 * 高可用
 * 可以解决：
 * 断路器：
 * 服务降级：防止高并发情况下，用户一直等待，直接返回一个友好提示给客户端，不会去处理请求，调用fallBack本地方法
 * 服务熔断：为了保护服务，在高并发情况下，如果请求达到一定的极限（可以自己设置阈值），采用服务降级方式返回一个提示
 * 服务隔离机制：每个服务自己有一个线程池，不会雪崩，但是这样cpu占用率很高，所以一般只有关键服务会这么开；有两种隔离方式，一种就是线程池，还有一种是信号量
 * 雪崩效应：
 */

@Service
public class HystrixService {

    /**
     * 默认开启线程池方式，避免服务雪崩
     * @HystrixCommand 一个注解就会同时开启，服务隔离，服务降级，服务熔断
     * hystrix默认超时时间是1秒，如果1秒内没有得到响应，就会走fallback方法，但是原先的方法（如本例callHystrixProvider）的业务逻辑（代码）会继续执行
     * @return
     */
    //@HystrixCommand(fallback = "feignInterfaceImpl.class"),这是写法二，不过需要这个impl去实现fiegn接口的方法，可以看feign那个示例
    @HystrixCommand(fallbackMethod = "failureCallBack")
    public String callHystrixProvider(){
        //这一步是为了验证hystrix是开启线程池的
        System.out.println("当前线程池名称是：" + Thread.currentThread().getName());

        //rest方式请求
        RestTemplate restTemplate = new RestTemplate();
        URI uri = URI.create("http://localhost:7600/sayHello");
        return restTemplate.getForObject(uri,String.class);

        //也可以使用feign方式请求，注解的方式需要在配置文件开启feign的hystrix为true
        //feignService.methodName();

    }

    /**
     * 这个回调方法其实就是服务降级执行
     * @return
     */
    public String failureCallBack(){
        return "hello,this is hystrix failure callback";
    }
}
