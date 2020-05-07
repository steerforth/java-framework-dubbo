package com.steer.dubbo.consumer.controller;

import com.steer.dubbo.extservice.service.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.service.EchoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EchoFilter
 */
@RestController()
@RequestMapping("/echo")
public class EchoController {
    @Reference(version = "1.0.0")
    HelloService helloService;
    /**
     * 回声测试，查看服务是否可用
     * @return
     */
    @GetMapping("")
    public Object echo(){
        EchoService echoService = (EchoService) helloService;
        return echoService.$echo("OK");
    }
}
