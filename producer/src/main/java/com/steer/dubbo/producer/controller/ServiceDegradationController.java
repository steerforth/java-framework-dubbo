package com.steer.dubbo.producer.controller;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.registry.Registry;
import org.apache.dubbo.registry.RegistryFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/degradation")
public class ServiceDegradationController {
    /**
     * mock=force:return+null 表示消费方对该服务的方法调用都直接返回null值
     * mock=fail:return+null 表示消费方对该服务的方法调用在失败后，再返回null值，不抛异常
     * @return
     */
    @GetMapping("")
    public Object degradation(){
        RegistryFactory registryFactory = ExtensionLoader.getExtensionLoader(RegistryFactory.class).getAdaptiveExtension();
        Registry registry = registryFactory.getRegistry(URL.valueOf("zookeeper://192.168.2.175:2181"));
        registry.register(URL.valueOf("override://0.0.0.0/com.steer.dubbo.extservice.service.HelloService?category=configurators&dynamic=false&application=producer&mock=force:return+null"));
        return "给服务com.steer.dubbo.extservice.service.HelloService降级";
    }
}
