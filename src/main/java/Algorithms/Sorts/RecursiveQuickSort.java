package Algorithms.Sorts;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 15/7/18
 * Recursive Quick sort
 * Average performance	O(n*log(n))
 * Worst-case performance	O(n^2)
 * Best-case performance	O(n*log(n))
 */

public class RecursiveQuickSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        doSort(array, 0, array.length - 1);
        return  array;
    }

    private <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        T pivot = array[right];
        int i = (left - 1);
        for (int j = left; j < right; j++)
        {
            if (SortAlgorithm.less(array[j], pivot))
            {
                i++;
                SortAlgorithm.swap(array, i, j);
            }
        }

        SortAlgorithm.swap(array, i + 1, right);
        return i+1;
    }

    private <T extends Comparable<T>> void doSort(T[] array, int low, int high) {
        if (low < high)
        {
            int tmp = partition(array, low, high);
            doSort(array, low, tmp - 1);
            doSort(array, tmp + 1, high);
        }
    }

}
