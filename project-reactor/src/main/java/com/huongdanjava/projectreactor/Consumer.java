package com.huongdanjava.projectreactor;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

public class Consumer<T> extends BaseSubscriber {

    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("Consumer: hookOnSubscribe.");
        request(1);
    }

    @Override
    protected void hookOnNext(Object value) {
        System.out.println("Consumer: hookOnNext " + value);
        request(1);
    }
}
