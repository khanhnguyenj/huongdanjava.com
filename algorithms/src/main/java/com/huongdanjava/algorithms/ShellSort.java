package com.huongdanjava.algorithms;

public class ShellSort {

  public static void main(String[] args) {
    int[] array = {3, -2, -5, 11, 39, 20};

    for (int gap = array.length / 2; gap > 0; gap /= 2) {

      for (int j = gap; j < array.length; j++) {
        int k = array[j];

        while (j >= gap && array[j - gap] > k) {
          array[j] = array[j - gap];

          j = j - gap;
        }
        array[j] = k;
      }
    }

    for (int i : array) {
      System.out.println(i);
    }
  }

}
