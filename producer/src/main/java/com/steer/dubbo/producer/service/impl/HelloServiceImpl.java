package com.steer.dubbo.producer.service.impl;

import com.steer.dubbo.extservice.service.HelloService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "你好 "+name;
    }
}
