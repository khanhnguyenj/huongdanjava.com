package com.huongdanjava.algorithms;

public class MaxHeap {

  private int[] heap;
  private int size;

  public MaxHeap(int capacity) {
    heap = new int[capacity];
  }

  public void insert(int value) {
    if (isFull()) {
      throw new IndexOutOfBoundsException("Heap is full");
    }

    heap[size] = value;

    fixHeap(size);

    size++;
  }

  private void fixHeap(int index) {
    int lastInsertedValue = heap[index];

    while (index > 0 && lastInsertedValue > heap[getParentIndex(index)]) {
      heap[index] = heap[getParentIndex(index)];
      index = getParentIndex(index);
    }

    heap[index] = lastInsertedValue;
  }

  private boolean isFull() {
    return size == heap.length;
  }

  private int getParentIndex(int childIndex) {
    return (childIndex - 1) / 2;
  }

}
