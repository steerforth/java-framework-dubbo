package com.steer.dubbo.consumer.controller;

import com.steer.dubbo.extservice.service.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/hello")
public class HelloController {
    /**
     * connections配置客户端最大连接数
     * sticky粘滞连接，默认启动lazy,减少长连接。尽可能让客户端总是向同一提供者发起调用。
     */
    @Reference(version = "1.0.0" )
    HelloService helloService;

    @GetMapping("")
    public Object hello(@RequestParam String name){
        return helloService.hello(name);
    }
}
