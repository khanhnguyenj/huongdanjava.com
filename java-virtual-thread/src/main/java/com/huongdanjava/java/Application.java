package com.huongdanjava.java;

public class Application {

  public static void main(String[] args) throws InterruptedException {
    for (int i = 0; i < 1_000_000; i++) {
      System.out.println("Creating thread " + i);
      Thread.startVirtualThread(new Runnable() {
        @Override
        public void run() {
          try {
            Thread.sleep(60000);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      });
    }

    Thread.sleep(60000);
  }

}
