package com.huongdanjava.callablefuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Example {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        // Create thread pool using Executor Framework
        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<Future<Integer>> list = new ArrayList<Future<Integer>>();
        for (int i = 0; i < 10; i++) {
            // Create new Calculator object
            Calculator c = new Calculator(i, i + 1);

            list.add(executor.submit(c));
        }

        for (Future f : list) {
            System.out.println(f.get(3, TimeUnit.SECONDS));
        }

        executor.shutdown();
    }
}
