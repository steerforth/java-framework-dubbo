package com.steer.dubbo.producer.service.impl;

import com.steer.dubbo.extservice.service.BarService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0")
public class BarServiceImpl implements BarService {
    @Override
    public String hello(String name) {
        return "你好,"+name;
    }
}
