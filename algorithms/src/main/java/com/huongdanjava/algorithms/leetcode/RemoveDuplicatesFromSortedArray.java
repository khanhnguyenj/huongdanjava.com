package com.huongdanjava.algorithms.leetcode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveDuplicatesFromSortedArray {

  public static void main(String[] args) {
    int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

    int arrayLength = nums.length;
    for (int i = 0; i < arrayLength; i++) {
      int processingValue = nums[i];
      for (int j = arrayLength - 1; j > i; j--) {
        if (nums[j] == processingValue) {
          arrayLength = doSwapForAnyOtherElementEqualToProcessingValue(j, arrayLength, nums);
        }
      }
    }

    System.out.println(arrayLength + "\n-----");

    for (int i : nums) {
      System.out.println(i);
    }
  }

  private static int doSwapForAnyOtherElementEqualToProcessingValue(int j, int arrayLength, int[] nums) {
    for (int s = j; s < arrayLength - 1; s++) {
      swap(nums, s, s + 1);
    }
    arrayLength--;

    return arrayLength;
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
