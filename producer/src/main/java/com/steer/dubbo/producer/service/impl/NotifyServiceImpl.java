package com.steer.dubbo.producer.service.impl;

import com.steer.dubbo.extservice.entity.Person;
import com.steer.dubbo.extservice.service.NotifyService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0",group = "cn")
public class NotifyServiceImpl implements NotifyService {
    @Override
    public Person createPerson(String id) {
        return new Person(id,"Li Mei",18);
    }
}
