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

    @Reference(version = "1.0.0")
    HelloService helloService;

    @GetMapping("")
    public Object hello(@RequestParam String name){
        return helloService.hello(name);
    }
}
