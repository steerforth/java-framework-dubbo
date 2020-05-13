package com.steer.dubbo.producer.service.impl;

import com.steer.dubbo.extservice.service.HelloService;
import org.apache.dubbo.config.annotation.Service;

/**
 * 尽可能在服务端配置consumer端属性
 * eg.timeout
 * retries
 * loadbalance:默认random
 * actives
 */
@Service(version = "1.0",interfaceClass = HelloService.class)
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "你好 "+name;
    }
}
