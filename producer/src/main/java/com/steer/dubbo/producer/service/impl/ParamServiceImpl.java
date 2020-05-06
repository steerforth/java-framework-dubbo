package com.steer.dubbo.producer.service.impl;

import com.steer.dubbo.extservice.service.ParamService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;

@Service(version = "1.0.0",interfaceClass = ParamService.class)
public class ParamServiceImpl implements ParamService {
    @Override
    public String hello() {
        String param = RpcContext.getContext().getAttachment("aaaa");
        return "收到隐式参数:"+param;
    }
}
