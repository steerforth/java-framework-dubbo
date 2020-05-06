package com.steer.dubbo.consumer.controller;

import com.steer.dubbo.extservice.service.AsyncService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController()
@RequestMapping("/async")
public class AsyncController {
    Logger log = LoggerFactory.getLogger(AsyncController.class);
    @Reference(version = "1.0.0",timeout = 10000)
    AsyncService asyncService;
    /**
     * 回声测试，查看服务是否可用
     * @return
     */
    @GetMapping("/consumer")
    public Object consumer(){
        CompletableFuture<String> future = asyncService.hello();
        future.whenComplete((v,t)->{
            if (t != null){
                t.printStackTrace();
            }else {
                log.info("收到异步信息:"+v);
            }
        });
        return "见日志";
    }
}
