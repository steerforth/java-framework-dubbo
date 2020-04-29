//package com.steer.dubbo.producer.config;
//
//import org.apache.dubbo.config.ApplicationConfig;
//import org.apache.dubbo.config.ConfigCenterConfig;
//import org.apache.dubbo.config.RegistryConfig;
//import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@DubboComponentScan(value ="com.steer.dubbo.producer.service.impl")
//public class DubboConfig {
//    @Bean
//    public ApplicationConfig appConfig(){
//        ApplicationConfig config = new ApplicationConfig();
//        config.setName("producer");
//        return config;
//    }
//
//    @Bean
//    public ConfigCenterConfig configCenterConfig() {
//        ConfigCenterConfig configCenterConfig = new ConfigCenterConfig();
//        configCenterConfig.setAddress("zookeeper://127.0.0.1:2181");
//        configCenterConfig.setProtocol("dubbo");
//        configCenterConfig.setGroup(null);
//        return configCenterConfig;
//    }
//
//    @Bean(name = "registryConfig")
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
//
//
//
//}
