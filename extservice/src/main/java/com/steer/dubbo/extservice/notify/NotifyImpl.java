package com.steer.dubbo.extservice.notify;

import com.steer.dubbo.extservice.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("Notify")
public class NotifyImpl implements Notify {
    Logger log = LoggerFactory.getLogger(NotifyImpl.class);
    public Map<Integer, Person> ret = new HashMap<>();
    public Map<Integer, Throwable> errors = new HashMap<>();

    @Override
    public void onreturn(Person msg, Integer id) {
        log.info("onreturn: person:{} id:{}",msg,id);
        ret.put(id, msg);
    }

    @Override
    public void onthrow(Throwable ex, Integer id) {
        errors.put(id, ex);
    }
}
