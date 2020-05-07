package com.steer.dubbo.consumer.service.impl;

import com.steer.dubbo.extservice.service.MockService;

public class MockServiceMock implements MockService {
    @Override
    public String hello(String name) {
        return "无producer服务，返回自定义mock数据";
    }
}
