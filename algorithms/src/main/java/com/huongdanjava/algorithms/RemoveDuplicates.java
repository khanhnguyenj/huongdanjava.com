package com.huongdanjava.algorithms;

public class RemoveDuplicates {

  public static void main(String[] args) {
    int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

    int k = nums.length;
    for (int i = 0; i < k; i++) {
      int h = nums[i];
      for (int j = k - 1; j > i; j--) {
        if (nums[j] == h) {
          for (int s = j; s < k - 1; s++) {
            swap(nums, s, s + 1);
          }
          k--;
        }
      }
    }

    System.out.println(k + "\n-----");

    for (int i : nums) {
      System.out.println(i);
    }
  }

  public static void swap(int[] array, int i, int j) {
    if (i == j) {
      return;
    }
    int k = array[j];
    array[j] = array[i];
    array[i] = k;
  }

}
