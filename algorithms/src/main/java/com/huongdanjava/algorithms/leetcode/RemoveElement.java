package com.huongdanjava.algorithms.leetcode;

/**
 * https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveElement {

  public static void main(String[] args) {
    int[] nums = {3, 3};
    int val = 3;

    int arrayLength = nums.length;
    for (int i = 0; i < arrayLength; i++) {
      if (nums[i] == val) {
        for (int j = arrayLength - 1; j > i; j--) {
          if (nums[j] != val) {
            swap(nums, i, j);
            break;
          } else {
            arrayLength--;
          }
        }
        arrayLength--;
      }
    }
    System.out.println(arrayLength);

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
