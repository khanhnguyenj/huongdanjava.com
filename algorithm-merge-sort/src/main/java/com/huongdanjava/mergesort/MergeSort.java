package com.huongdanjava.mergesort;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort {

	public <K> K[] doMergeSort(K[] arrayNeedToSort, Comparator<K> comparator) {
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

	private <K> K[] merge(K[] sortedSubArrayFirst, K[] sortedSubArraySecond, Comparator<K> comparator) {
		int n = sortedSubArrayFirst.length + sortedSubArraySecond.length;
		K[] sortedArray = (K[]) new Object[n];

		int i = 0;
		int j = 0;
		for (int k = 0; k < n; k++) {
			if (i < sortedSubArrayFirst.length && comparator.compare(sortedSubArrayFirst[i], sortedSubArraySecond[j]) < 1) {
				sortedArray[k] = sortedSubArrayFirst[i];
				if (i < sortedSubArrayFirst.length - 1) {
					i++;
				}
			} else if (j < sortedSubArraySecond.length && comparator.compare(sortedSubArraySecond[j], sortedSubArrayFirst[i]) < 1) {
				sortedArray[k] = sortedSubArraySecond[j];
				if (j < sortedSubArraySecond.length - 1) {
					j++;
				}
			}
		}

		return sortedArray;
	}

	public static void main(String args[]) {
		MergeSort mergeSort = new MergeSort();
		Integer[] array = { 1, 23, 4, 5, 100, 54 };

		Integer[] sortedArray = mergeSort.doMergeSort(array, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if (o1 > o2)
					return 1;
				else if (o1 == o2)
					return 0;
				else
					return -1;
			}
		});

		System.err.println(sortedArray);
	}
}
