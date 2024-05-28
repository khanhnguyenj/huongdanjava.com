package com.huongdanjava.algorithms;

import java.util.Arrays;

public class ReverseArray {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5, 6, 7};

    for (int i = 0; i < nums.length; i++) {
      int v = nums[nums.length - 1];
      for (int j = nums.length - 1; j >= 0; j--) {
        if (j == 0) {
          nums[j] = v;
        } else {
          nums[j] = nums[j - 1];
        }
      }
    }
    Arrays.stream(nums).forEach(System.out::println);
  }
}
