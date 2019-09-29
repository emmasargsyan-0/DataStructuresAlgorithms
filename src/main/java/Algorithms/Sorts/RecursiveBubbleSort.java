package Algorithms.Sorts;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 15/7/18
 * Recursive Bubble sort
 * Average performance	O(n^2)
 * Worst-case performance	O(n^2)
 * Best-case performance	O(n)
 */

public class RecursiveBubbleSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) {
        bubbleSort(arr, (arr.length-1) );
        return  arr;
    }

    private <T extends Comparable<T>> void bubbleSort(T[] arr, int n)
    {
        if (n == 0) {
            return;
        }

        for (int i = 0; i < n; i++) {
            if (SortAlgorithm.less(arr[i + 1], arr[i])) {
                SortAlgorithm.swap(arr, i, i + 1);
            }
        }

        bubbleSort(arr, n-1);
    }

}
