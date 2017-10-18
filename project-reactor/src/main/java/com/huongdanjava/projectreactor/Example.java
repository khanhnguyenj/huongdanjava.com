package com.huongdanjava.projectreactor;

import reactor.core.publisher.Flux;

import java.util.concurrent.TimeUnit;

public class Example {

    public static void main(String[] args) throws InterruptedException {
        Flux flux = Flux.just("Khanh", "Quan", "Thanh");

        flux.subscribe(new Consumer());

        TimeUnit.SECONDS.sleep(10);
    }
}
