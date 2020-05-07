package com.steer.dubbo.consumer.controller;

import com.steer.dubbo.extservice.listener.CallbackListener;
import com.steer.dubbo.extservice.service.CallbackService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController()
@RequestMapping("/callback")
public class CallbackContrller implements Serializable {
    Logger log = LoggerFactory.getLogger(CallbackContrller.class);
    @Reference(version = "1.0")
    CallbackService callbackService;
    /**
     *
     * @return
     */
    @GetMapping("")
    public Object callback(){
        callbackService.addListener("foo.bar", new CallbackListener(){
            @Override
            public void changed(String msg) {
                log.info("callback:"+msg);
            }
        });
        return "见日志";
    }
}
