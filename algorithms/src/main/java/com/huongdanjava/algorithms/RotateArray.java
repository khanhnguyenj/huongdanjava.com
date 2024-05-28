package com.huongdanjava.algorithms;

import java.util.Arrays;

public class RotateArray {

  public static void main(String[] args) {
    //int[] nums = {1, 2, 3, 4, 5, 6, 7};
    int[] nums = {1,2};
    int k = 3;

    if (nums.length > 1) {

      if (nums.length > k) {

        int[] nums1 = new int[k];
        int t = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
          nums1[t] = nums[i];
          t++;
        }

        int[] nums2 = new int[nums.length - k];
        int h = 0;
        for (int i = 0; i < nums.length - k; i++) {
          nums2[h] = nums[i];
          h++;
        }

        int l = 0;
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
          if (i < k) {
            nums[i] = nums1[l];
            l++;
          } else {
            nums[i] = nums2[m];
            m++;
          }
        }
      }
      else {

        Arrays.stream(nums).forEach(System.out::println);
        System.out.println("a");
            for (int i = 0; i < nums.length-1; i++) {
      int v = nums[nums.length - 1];
      for (int j = nums.length - 1; j >=0; j--) {
        if (j == 0) {
          nums[j] = v;
        } else {
          nums[j] = nums[j - 1];
        }
      }
    }
      }
    }

    //Arrays.stream(nums2).forEach(System.out::println);

//    for (int i = 0; i < k; i++) {
//      int v = nums[nums.length - 1];
//      for (int j = nums.length - 1; j >= 0; j--) {
//        if (j == 0) {
//          nums[j] = v;
//        } else {
//          nums[j] = nums[j - 1];
//        }
//      }
//    }

    Arrays.stream(nums).forEach(System.out::println);
  }
}
