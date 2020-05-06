package com.steer.dubbo.consumer.controller;

import com.steer.dubbo.extservice.service.HelloService;
import com.steer.dubbo.extservice.service.ParamService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.service.EchoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 上下文信息
 * RpcContext 是一个 ThreadLocal 的临时状态记录器
 */
@RestController()
@RequestMapping("/context")
public class ContextController {
    @Reference(version = "1.0.0")
    HelloService helloService;

    @Reference(version = "1.0.0")
    ParamService paramService;
    /**
     * 回声测试，查看服务是否可用
     * @return
     */
    @GetMapping("")
    public Object context(@RequestParam String name){
        String res = helloService.hello(name);
        //判断是否为消费端
        boolean consumerSide = RpcContext.getContext().isConsumerSide();
        //最后一次调用的服务端ip
        String serverId = RpcContext.getContext().getRemoteHost();
        //获取当前服务的配置信息
        String application = RpcContext.getContext().getUrl().getParameter("application");
        return "是否为消费端:"+consumerSide+" 最后一次调用的服务端ip："+serverId+" 配置信息:"+application;
    }

    /**
     * 回声测试，查看服务是否可用
     * @return
     */
    @GetMapping("/param")
    public Object param(@RequestParam String param){
        //传递隐式参数   调用链会走filter，设置参数；  再走代理动态proxy调用
        RpcContext.getContext().setAttachment("aaaa",param);
        String res = paramService.hello();
        return res;
    }
}
