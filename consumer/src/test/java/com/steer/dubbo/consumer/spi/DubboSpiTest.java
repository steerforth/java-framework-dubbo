package com.steer.dubbo.consumer.spi;

import com.steer.dubbo.consumer.ConsumerApplicationTests;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

public class DubboSpiTest extends ConsumerApplicationTests {
    @Test
    public void test(){
        ExtensionLoader<Animal> extensionLoader =
                ExtensionLoader.getExtensionLoader(Animal.class);
        Animal cat = extensionLoader.getExtension("cat");
        cat.eat();
        Animal dog = extensionLoader.getExtension("dog");
        dog.eat();
    }
}
