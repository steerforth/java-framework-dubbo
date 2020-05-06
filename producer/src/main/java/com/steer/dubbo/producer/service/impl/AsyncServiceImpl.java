package com.steer.dubbo.producer.service.impl;

import com.steer.dubbo.extservice.service.AsyncService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

@Service(version = "1.0.0")
public class AsyncServiceImpl implements AsyncService {
    Logger log = LoggerFactory.getLogger(AsyncServiceImpl.class);
    @Override
    public CompletableFuture<String> hello() {
        RpcContext savedContext = RpcContext.getContext();
        // 建议为supplyAsync提供自定义线程池，避免使用JDK公用线程池
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "async response from provider.";
        });
    }
}
