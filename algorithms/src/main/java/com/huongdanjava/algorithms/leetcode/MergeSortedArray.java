package com.huongdanjava.algorithms.leetcode;

/**
 * https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MergeSortedArray {

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int[] nums2 = {2, 5, 6};
    int m = 3;
    int n = 3;

    for (int j = n - 1; j >= 0; j--) {
      int mergingValue = nums2[j];
      boolean canMergeToTheEnd = true;

      int i;
      for (i = m - 1; i >= 0; i--) {
        if (nums1[i] > mergingValue) {
          canMergeToTheEnd = false;
          nums1[i + 1] = nums1[i];
        } else {
          break;
        }
      }

      if (canMergeToTheEnd) {
        nums1[m] = mergingValue;
      } else {
        nums1[i + 1] = mergingValue;
      }
      m++;
    }

    for (int l : nums1) {
      System.out.println(l);
    }
  }
}
