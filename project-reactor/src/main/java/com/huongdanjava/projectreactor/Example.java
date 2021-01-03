package com.huongdanjava.projectreactor;

import java.util.concurrent.TimeUnit;

import reactor.core.publisher.Flux;

public class Example {

    public static void main(String[] args) throws InterruptedException {
        Flux<String> flux = Flux.just("Khanh", "Quan", "Thanh");

        flux.subscribe(new Consumer());

        TimeUnit.SECONDS.sleep(10);
    }
}
