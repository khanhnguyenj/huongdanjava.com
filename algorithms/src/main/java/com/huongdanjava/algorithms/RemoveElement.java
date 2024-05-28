package com.huongdanjava.algorithms;

public class RemoveElement {

  public static void main(String[] args) {
    int[] nums = {3, 3};
    int val = 3;

    int k = nums.length;
    for (int i = 0; i < k; i++) {
      if (nums[i] == val) {
        for (int j = k - 1; j > i; j--) {
          if (nums[j] != val) {
            swap(nums, i, j);
            break;
          } else {
            k--;
          }
        }
        k--;
      }
    }
    System.out.println(k);

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
