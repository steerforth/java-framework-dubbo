package com.steer.dubbo.consumer.controller;

import com.steer.dubbo.extservice.entity.Person;
import com.steer.dubbo.extservice.notify.NotifyImpl;
import com.steer.dubbo.extservice.service.NotifyService;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * FutureFilter
 */
@RestController()
@RequestMapping("/notify")
public class NotifyController {
    Logger log = LoggerFactory.getLogger(NotifyController.class);
    //TODO FutureFilter 方法回调后，找不到Notify.onreturn方法   还是用XML？
    @Reference(version = "1.0.0",group = "cn",methods = {@Method(name = "createPerson", async = false,onreturn = "Notify.onreturn",onthrow = "Notify.onthrow")})
//    @Reference(version = "1.0.0",group = "cn")
    NotifyService notifyService;
    @Autowired
    private NotifyImpl notify;

    /**
     * 在consumer端，方法执行的前后调用，以及抛异常的调用
     * @param id
     * @return
     * @throws InterruptedException
     */
    @GetMapping("")
    public Object notify(@RequestParam String id) throws InterruptedException {
        Person person = notifyService.createPerson(id);
        log.info("=========>{}",person);
        Thread.sleep(2000);
        log.info("---{}---",notify.ret.entrySet().size());
//        notify.ret.
        return person;
    }
}
