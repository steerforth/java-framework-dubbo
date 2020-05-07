package com.steer.dubbo.consumer.controller;

import com.steer.dubbo.extservice.service.TokenService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/token")
public class TokenController {
    @Reference(version = "1.0.0")
    TokenService tokenService;
    /**
     * token令牌
     * token主要限制绕过注册中心的直连
     * @return
     */
    @GetMapping("")
    public Object token(@RequestParam String name){
        //本质就是通过RpcContext来设置token
//        RpcContext.getContext().setAttachment("token","123");
        return tokenService.hello(name);
    }
}
