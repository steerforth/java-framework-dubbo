package com.steer.dubbo.consumer.spi;

public class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("猫吃东西");
    }
}
