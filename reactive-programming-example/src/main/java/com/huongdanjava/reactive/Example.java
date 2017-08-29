package com.huongdanjava.reactive;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class Example {

	public static void main(String[] args) {
		Observable<Integer> b = Observable.just(2, 5);
		final int c = 3;

		Consumer<Integer> consumer = new Consumer<Integer>() {

			int a = 0;

			public void accept(Integer number) throws Exception {
				a = number + c;
				System.out.println(a);
			}
		};

		b.subscribe(consumer);
	}
}
