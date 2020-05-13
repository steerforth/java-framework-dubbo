package com.steer.dubbo.consumer.spi;

public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("狗吃东西");
    }
}
