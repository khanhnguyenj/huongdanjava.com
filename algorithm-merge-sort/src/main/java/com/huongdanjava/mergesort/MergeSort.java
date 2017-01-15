package com.huongdanjava.mergesort;

import java.lang.reflect.Array;
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

		K[] sortedArray = (K[]) Array.newInstance(sortedSubArrayFirst[0].getClass(), n);

		int i = 0;
		int j = 0;
		for (int k = 0; k < n; k++) {
			if (j == sortedSubArraySecond.length || (i < sortedSubArrayFirst.length
				&& comparator.compare(sortedSubArrayFirst[i], sortedSubArraySecond[j]) < 1)) {
				sortedArray[k] = sortedSubArrayFirst[i++];
			} else {
				sortedArray[k] = sortedSubArraySecond[j++];
			}
		}

		return sortedArray;
	}

}
