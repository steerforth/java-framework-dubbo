package com.steer.dubbo.extservice.service;

import com.steer.dubbo.extservice.listener.CallbackListener;

public interface CallbackService {
    void addListener(String key, CallbackListener listener);
}
