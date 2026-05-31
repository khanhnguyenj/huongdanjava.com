package com.huongdanjava.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class Application {

  static void main(String[] args) {
    Deque<Integer> deque = new ArrayDeque<>();
    deque.add(3);
    deque.add(4);

    System.out.println("getFirst: " + deque.getFirst());
    System.out.println("getLast: " + deque.getLast());
    System.out.println("peekFirst: " + deque.peekFirst());
    System.out.println("peekLast: " + deque.peekLast());

    deque.forEach(System.out::println);

    System.out.println("removeFirst: " + deque.removeFirst());

    System.out.println("peekFirst: " + deque.peekFirst());
    System.out.println("getLast:" + deque.getLast());

    deque.forEach(System.out::print);
  }

}
