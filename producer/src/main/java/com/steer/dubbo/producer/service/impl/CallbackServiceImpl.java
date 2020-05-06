package com.steer.dubbo.producer.service.impl;

import com.steer.dubbo.extservice.listener.CallbackListener;
import com.steer.dubbo.extservice.service.CallbackService;
import org.apache.dubbo.config.annotation.Argument;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Service(version = "1.0.0",connections = 1,callbacks = 10,methods={ @Method(name = "addListener",arguments = {@Argument(index = 1,callback = true)})})
public class CallbackServiceImpl implements CallbackService {
    private final Map<String, CallbackListener> listeners = new ConcurrentHashMap<>();


    @Override
    public void addListener( String key, CallbackListener listener) {
        listeners.put(key, listener);
        listener.changed(getChanged(key)); // 发送变更通知
    }

    public CallbackServiceImpl() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        for(Map.Entry<String, CallbackListener> entry : listeners.entrySet()){
                            try {
                                entry.getValue().changed(getChanged(entry.getKey()));
                            } catch (Throwable t) {
                                listeners.remove(entry.getKey());
                            }
                        }
                        Thread.sleep(5000); // 定时触发变更通知
                    } catch (Throwable t) { // 防御容错
                        t.printStackTrace();
                    }
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }

    private String getChanged(String key) {
        return "[Key:"+key+" Changed at: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"]";
    }
}
