package com.steer.dubbo.extservice.service;

import java.util.concurrent.CompletableFuture;

public interface AsyncService {
    CompletableFuture<String> hello();
}
