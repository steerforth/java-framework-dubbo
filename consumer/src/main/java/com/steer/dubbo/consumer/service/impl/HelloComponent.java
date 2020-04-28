package com.steer.dubbo.consumer.service.impl;

import com.steer.dubbo.extservice.service.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class HelloComponent {
    @Reference
    HelloService helloService;

    public String hello(String name){
       return helloService.hello(name);
    }
}
