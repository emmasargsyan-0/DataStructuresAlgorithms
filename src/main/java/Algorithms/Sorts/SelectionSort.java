package Algorithms.Sorts;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 9/7/18
 * Selection sort
 * Average performance	O(n^2)
 * Worst-case performance	O(n^2)
 * Best-case performance	O(n^2)
 */

public class SelectionSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < length; j++) {
                if (SortAlgorithm.less(arr[j], arr[min])) {
                    min = j;
                }
            }

            if (min != i) {
                SortAlgorithm.swap(arr, i, min);
            }
        }

        return arr;
    }

}
