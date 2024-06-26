package com.huongdanjava.algorithms.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveDuplicatesFromSortedArrayII {

  public static void main(String[] args) {
    int[] nums = {0, 0, 1, 1, 1, 1, 2, 2, 3, 3, 4};

    int arrayLength = nums.length;
    for (int i = 0; i < arrayLength - 1; i++) {
      int processingValue = nums[i];
      if (isNextElementEqualToProcessingValue(processingValue, nums[i + 1])) {
        i++;
        arrayLength = doSwapForAnyOtherElementEqualToProcessingValue(arrayLength, i, nums,
            processingValue);
      }
    }

    System.out.println(arrayLength + "\n-----");

    for (int i : nums) {
      System.out.println(i);
    }

  }

  private static int doSwapForAnyOtherElementEqualToProcessingValue(int arrayLength, int i,
      int[] nums, int processingValue) {
    for (int j = arrayLength - 1; j > i; j--) {
      if (nums[j] == processingValue) {
        for (int s = j; s < arrayLength - 1; s++) {
          swap(nums, s, s + 1);
        }
        arrayLength--;
      }
    }

    return arrayLength;
  }

  private static boolean isNextElementEqualToProcessingValue(int processingValue,
      int nextElementValue) {
    return processingValue == nextElementValue;
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
