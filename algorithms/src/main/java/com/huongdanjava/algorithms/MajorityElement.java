package com.huongdanjava.algorithms;

public class MajorityElement {

  public static void main(String[] args) {
    int[] nums = {3, 2, 3};

    System.out.println(majorityElement(nums));
  }

  public static int majorityElement(int[] nums) {
    int majorityElement = -1;
    for (int i = 0; i < nums.length; i++) {
      majorityElement = nums[i];
      int appeared = 1;

      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] == majorityElement) {
          appeared++;
        }

        if (appeared > nums.length / 2) {
          return majorityElement;
        }
      }

    }

    return majorityElement;
  }

}
