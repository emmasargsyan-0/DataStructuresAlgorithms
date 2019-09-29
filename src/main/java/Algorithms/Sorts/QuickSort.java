package Algorithms.Sorts;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 19/7/18
 * Quick sort
 * Average performance	O(n*log(n))
 * Worst-case performance	O(n^2)
 * Best-case performance	O(n*log(n))
 */

public class QuickSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        doSort(array, 0, array.length - 1);
        return array;
    }

    private <T extends Comparable<T>> void doSort(T[] array, int left, int right) {
        if (left < right) {
            int index = partition(array, left, right);
            doSort(array, left, index - 1);
            doSort(array, index, right);
        }
    }

    private <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        int mid = (left + right) / 2;
        T pivot = array[mid];

        while (left <= right) {
            while (SortAlgorithm.less(array[left], pivot)) {
                ++left;
            }
            while (SortAlgorithm.less(pivot, array[right])) {
                --right;
            }
            if (left <= right) {
                SortAlgorithm.swap(array, left, right);
                ++left;
                --right;
            }
        }
        return left;
    }

}

