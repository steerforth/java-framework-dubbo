package com.steer.dubbo.consumer.controller;

import com.steer.dubbo.extservice.service.AuthService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/auth")
public class AuthController {
    @Reference(version = "1.0.0")
    AuthService authService;
    /**
     * TODO 目前无效果
     * @return
     */
    @GetMapping("")
    public Object auth() {
        return authService.hello();
    }
}
