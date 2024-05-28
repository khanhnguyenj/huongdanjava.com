package com.huongdanjava.algorithms;

public class BubbleSort {

  public static void main(String[] args) {
    int[] array = {3, -2, -5, 11, 39, 20};

    for (int i = array.length - 1; i >= 0; i--) {
      for (int j = 0; j < i; j++) {
        if (array[j] > array[j + 1]) {
          swap(array, j, j + 1);
        }
      }
    }

    for (int i : array) {
      System.out.println(i);
    }
  }

  public static void swap(int[] array, int i, int j) {
    int k = array[j];
    array[j] = array[i];
    array[i] = k;
  }

}
