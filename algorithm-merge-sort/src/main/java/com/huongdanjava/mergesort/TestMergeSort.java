package com.huongdanjava.mergesort;

import java.util.Comparator;

public class TestMergeSort {

    public static void main(String args[]) {
        MergeSort mergeSort = new MergeSort();
        Integer[] array = {1, 23, 4, 5, 100, 54};

        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2)
                    return 1;
                else if (o1 == o2)
                    return 0;
                else
                    return -1;
            }
        };
        Integer[] sortedArray = mergeSort.doMergeSort(array, comparator);

        for (Integer o : sortedArray) {
            System.err.println(o.intValue());
        }
    }
}
