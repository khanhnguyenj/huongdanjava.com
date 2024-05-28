package com.huongdanjava.algorithms;

public class MergeSortedArray {

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int[] nums2 = {2, 5, 6};
    int m = 3;
    int n = 3;

    for (int j = n - 1; j >= 0; j--) {
      int h = nums2[j];
      boolean a = true;

      int i;
      for (i = m - 1; i >= 0; i--) {
        if (nums1[i] > h) {
          a = false;
          nums1[i + 1] = nums1[i];
        } else {
          break;
        }
      }

      if (a) {
        nums1[m] = h;
      } else {
        nums1[i + 1] = h;
      }
      m++;
    }

    for (int l : nums1) {
      System.out.println(l);
    }
  }
}
