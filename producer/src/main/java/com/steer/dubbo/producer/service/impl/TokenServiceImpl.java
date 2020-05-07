package com.steer.dubbo.producer.service.impl;

import com.steer.dubbo.extservice.service.TokenService;
import org.apache.dubbo.config.annotation.Service;

//给服务设置token,设置为ture,则产生随机UUID
@Service(version = "1.0",interfaceClass = TokenService.class,token = "123456")
public class TokenServiceImpl implements TokenService {
    @Override
    public String hello(String name) {
        return "你好,"+name;
    }
}
