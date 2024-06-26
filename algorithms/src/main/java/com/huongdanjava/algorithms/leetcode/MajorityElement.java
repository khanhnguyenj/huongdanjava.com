package com.huongdanjava.algorithms.leetcode;

/**
 * https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MajorityElement {

  public static void main(String[] args) {
    int[] nums = {3, 2, 3,2,2};

    System.out.println(majorityElement(nums));
  }

  public static int majorityElement(int[] nums) {
    int majorityElement = -1;
    int arrayLength = nums.length;
    for (int i = 0; i < arrayLength; i++) {
      majorityElement = nums[i];
      int appeared = 1;

      for (int j = i + 1; j < arrayLength; j++) {
        if (nums[j] == majorityElement) {
          appeared++;
        }

        if (appeared > arrayLength / 2) {
          return majorityElement;
        }
      }

    }

    return majorityElement;
  }

}
