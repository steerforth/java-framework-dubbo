package com.steer.dubbo.extservice.notify;

import com.steer.dubbo.extservice.entity.Person;

public interface Notify {
    public void onreturn(Person msg, Integer id);
    public void onthrow(Throwable ex, Integer id);
}
