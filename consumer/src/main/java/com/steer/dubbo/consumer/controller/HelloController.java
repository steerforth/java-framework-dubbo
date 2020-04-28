package com.steer.dubbo.consumer.controller;

import com.steer.dubbo.consumer.service.impl.HelloComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    HelloComponent component;

    @GetMapping("")
    public Object hello(@RequestParam String name){
        return component.hello(name);
    }
}
