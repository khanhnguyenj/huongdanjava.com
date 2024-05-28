package com.huongdanjava.algorithms;

public class RemoveDuplicatesInSortedArray {

  public static void main(String[] args) {
    int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

    int k = nums.length;
    for (int i = 0; i < k - 1; i++) {
      int h = nums[i];
      if (h == nums[i + 1]) {
        for (int j = k - 1; j > i + 1; j--) {
          if (nums[j] == h) {
            for (int s = j; s <= k - 1; s++) {
              if (s == k - 1) {
                nums[s] = h;
              } else {
                nums[s] = nums[s + 1];
              }
            }
            k--;
          }
        }
        i++;
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
