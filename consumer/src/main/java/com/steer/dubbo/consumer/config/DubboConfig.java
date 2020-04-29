//package com.steer.dubbo.consumer.config;
//
//import com.steer.dubbo.extservice.service.HelloService;
//import org.apache.dubbo.config.ApplicationConfig;
//import org.apache.dubbo.config.ConfigCenterConfig;
//import org.apache.dubbo.config.ReferenceConfig;
//import org.apache.dubbo.config.RegistryConfig;
//import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@DubboComponentScan(value ="com.steer.dubbo.consumer.service.impl")
//public class DubboConfig {
//    @Bean
//    public ApplicationConfig appConfig(){
//        ApplicationConfig config = new ApplicationConfig();
//        config.setName("consumer");
//        return config;
//    }
//
//    @Bean
//    public ConfigCenterConfig configCenterConfig() {
//        ConfigCenterConfig configCenterConfig = new ConfigCenterConfig();
//        configCenterConfig.setAddress("zookeeper://127.0.0.1:2181");
//        configCenterConfig.setProtocol("dubbo");
//        configCenterConfig.setNamespace("dubbo");
//        configCenterConfig.setGroup(null);
//        return configCenterConfig;
//    }
//
//    @Bean
//    public RegistryConfig registryConfig() {
//        RegistryConfig registryConfig = new RegistryConfig();
//        registryConfig.setCheck(false);
//        registryConfig.setProtocol("zookeeper");
//        //请求超时时间(单位: 毫秒)
//        registryConfig.setTimeout(60000);
//        registryConfig.setAddress(configCenterConfig().getAddress());
//        registryConfig.setClient("curator");
//        //只订阅不注册，毕竟unipass目前也没有对外提供dubbo服务的打算
//        registryConfig.setRegister(false);
//        return registryConfig;
//    }
//
//    @Bean
//    public ReferenceConfig referenceConfig(){
//        ReferenceConfig<HelloService> reference = new ReferenceConfig<HelloService>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
//        reference.setApplication(appConfig());
//        reference.setRegistry(registryConfig()); // 多个注册中心可以用setRegistries()
//        reference.setInterface(HelloService.class);
//        reference.setVersion("2.7.6");
//        return reference;
//    }
//
//
//
//
//}
