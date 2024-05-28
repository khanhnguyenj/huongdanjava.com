package com.huongdanjava.algorithms;

public class InsertionSort {

  public static void main(String[] args) {
    int[] array = {3, -2, -5, 11, 39, 20};

    for (int i = 1; i < array.length; i++) {
      int k = array[i];
      int j;
      for (j = i; j > 0 && array[j - 1] > k; j--) {
        array[j] = array[j - 1];
      }

      array[j] = k;
    }

    for (int i : array) {
      System.out.println(i);
    }
  }

}
