package com.steer.dubbo.consumer.controller;

import com.steer.dubbo.extservice.service.BarService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/stub")
public class StubController {
    @Reference(version = "1.0",stub = "com.steer.dubbo.consumer.service.impl.BarServiceStub")
    BarService barService;
    /**
     * 本地存根
     * @return
     */
    @GetMapping("")
    public Object stub(@RequestParam String name){
        return barService.hello(name);
    }
}
