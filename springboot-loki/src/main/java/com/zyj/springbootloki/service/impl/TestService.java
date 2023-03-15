package com.zyj.springbootloki.service.impl;

import com.zyj.springbootloki.LokiLabelType;
import com.zyj.springbootloki.annotation.LokiLabel;
import com.zyj.springbootloki.service.ITestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestService implements ITestService {

    //方法二，使用注解统一打标签
    //@LokiLabel(type = LokiLabelType.A)
    @Override
    public void sayHello() {
        log.info("这是service日志");
    }
}
