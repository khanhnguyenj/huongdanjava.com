package com.huongdanjava.mergesort;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort {

    public static <K> K[] doMergeSort(K[] arrayNeedToSort, Comparator<K> comparator) {
        int n = arrayNeedToSort.length;
        if (n < 2) {
            return arrayNeedToSort;
        }

        int middle = n / 2;

        K[] subArrayFirst = Arrays.copyOfRange(arrayNeedToSort, 0, middle);
        K[] sortedSubArrayFirst = doMergeSort(subArrayFirst, comparator);

        K[] subArrayLast = Arrays.copyOfRange(arrayNeedToSort, middle, n);
        K[] sortedSubArraySecond = doMergeSort(subArrayLast, comparator);

        return merge(sortedSubArrayFirst, sortedSubArraySecond, comparator);
    }

    private static <K> K[]  merge(K[] sortedSubArrayFirst, K[] sortedSubArraySecond, Comparator<K> comparator) {
        int n = sortedSubArrayFirst.length + sortedSubArraySecond.length;
        K[] sortedArray = (K[]) new Object[n];

        int i = 0;
        int j = 0;
        for (int k = 0; k < n; k++) {
            if (comparator.compare(sortedSubArrayFirst[i], sortedSubArraySecond[j]) <= 1) {
                sortedArray[k] = sortedSubArrayFirst[i];
                i++;
            } else if (comparator.compare(sortedSubArraySecond[j], sortedSubArrayFirst[i]) <= 1) {
                sortedArray[k] = sortedSubArraySecond[j];
                j++;
            }
        }

        return sortedArray;
    }
}
