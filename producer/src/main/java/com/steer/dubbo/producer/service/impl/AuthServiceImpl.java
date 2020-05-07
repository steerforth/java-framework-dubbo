package com.steer.dubbo.producer.service.impl;

import com.steer.dubbo.extservice.service.AuthService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0",parameters = {"service.auth","true","param.sign","true"})
public class AuthServiceImpl implements AuthService {
    @Override
    public String hello() {
        return "你好～～～";
    }
}
