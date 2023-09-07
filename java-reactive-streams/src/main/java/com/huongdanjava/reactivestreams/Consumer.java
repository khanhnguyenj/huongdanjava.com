package com.huongdanjava.reactivestreams;

import java.util.concurrent.Flow;

public class Consumer implements Flow.Subscriber {

  private Flow.Subscription subscription;

  public void onSubscribe(Flow.Subscription subscription) {
    System.out.println("Consumer: onSubscribe");
    this.subscription = subscription;
    subscription.request(2);
  }

  public void onNext(Object item) {
    System.out.println("Consumer: onNext" + item);
    subscription.request(1);
  }

  public void onError(Throwable throwable) {
    System.out.println("Consumer: onError");
  }

  public void onComplete() {
    System.out.println("Consumer: onComplete");
  }
}
