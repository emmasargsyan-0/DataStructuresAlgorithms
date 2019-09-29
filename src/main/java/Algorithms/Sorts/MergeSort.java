package Algorithms.Sorts;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 11/7/18
 * Merge sort
 * Average performance	O(n*log(n))
 * Worst-case performance	O(n*log(n))
 * Best-case performance	O(n*log(n))
*/

public class MergeSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        T[] tempArray = (T[]) new Comparable[array.length];
        doSort(array, tempArray, 0, array.length - 1);
        return array;
    }

    private static <T extends Comparable<T>> void doSort(T[] array, T[] tempArray, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            doSort(array, tempArray, left, mid);
            doSort(array, tempArray, mid + 1, right);
            mergeArray(array, tempArray, left, mid, right);
        }
    }

    private static <T extends Comparable<T>> void mergeArray(T[] array, T[] tempArray, int left, int mid, int right) {
        System.arraycopy(array, left, tempArray, left, right - left + 1);
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (SortAlgorithm.less(tempArray[i],tempArray[j]) ) {
                array[k++] = tempArray[i++];
            } else {
                array[k++] = tempArray[j++];
            }
        }

        while (i <= mid) {
            array[k++] = tempArray[i++];
        }

        while (j <= right) {
            array[k++] = tempArray[j++];
        }
    }

}
