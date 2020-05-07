package com.steer.dubbo.consumer.service.impl;

import com.steer.dubbo.extservice.service.BarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Service(version = "1.0.0",stub = "com.steer.dubbo.extservice.service.BarService.BarServiceStub")
public class BarServiceStub implements BarService {
    private Logger log = LoggerFactory.getLogger(BarServiceStub.class);
    private final BarService barService;

    // 构造函数传入真正的远程代理对象
    public BarServiceStub(BarService barService) {
        this.barService = barService;
    }

    @Override
    public String hello(String name) {
        log.info(">>>>>>>>>>>consumer start bar<<<<<<<<<<<");
        //AOP
        try {
            return barService.hello(name);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "容错数据";
    }
}
