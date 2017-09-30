package com.huongdanjava.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Example {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Create new Calculator object
        Calculator c = new Calculator(2, 3);

        CompletableFuture<Integer> f = CompletableFuture.supplyAsync(c);

        f.thenAccept(result -> {
            System.out.println(result);
        });

        System.out.println("End...");

        Thread.sleep(10000);
    }
}