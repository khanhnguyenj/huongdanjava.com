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

        K[] subArray1 = Arrays.copyOfRange(arrayNeedToSort, 0, middle);
        doMergeSort(subArray1, comparator);

        K[] subArray2 = Arrays.copyOfRange(arrayNeedToSort, middle, n);
        doMergeSort(subArray2, comparator);

        merge(subArray1, subArray2, comparator);

        return arrayNeedToSort;
    }

    private static <K> void merge(K[] subArray1, K[] subArray2, Comparator<K> comparator) {
    }
}
