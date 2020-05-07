package com.steer.dubbo.consumer.controller;

import com.steer.dubbo.extservice.service.MockService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/mock")
public class MockController {

    @Reference(version = "1.0.0",mock = "com.steer.dubbo.consumer.service.impl.MockServiceMock")
    MockService mockService;
    /**
     * 本地伪造
     * 无producer提供服务时，返回本地mock数据
     * @return
     */
    @GetMapping("")
    public Object mock(@RequestParam String name){
        return mockService.hello(name);
    }
}
