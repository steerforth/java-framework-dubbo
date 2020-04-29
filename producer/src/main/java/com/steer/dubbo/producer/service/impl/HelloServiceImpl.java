package com.steer.dubbo.producer.service.impl;

import com.steer.dubbo.extservice.service.HelloService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0",interfaceClass = HelloService.class)
//@Service(version = "1.0.0",interfaceClass = HelloService.class)
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "你好 "+name;
    }
}
