package Algorithms.Sorts;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 19/7/18
 * Recursive Insertion sort
 * Average performance	O(n^2)
 * Worst-case performance	O(n^2)
 * Best-case performance	O(n)
 */

public class RecursiveInsertionSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        return insertionSortRecursive(array, array.length);
    }

    private <T extends Comparable<T>> T[] insertionSortRecursive(T[] array, int length)
    {
        if (length <= 1) {
            return array;
        }

        insertionSortRecursive( array, length - 1 );

        T last = array[length - 1];
        int j = length - 2;

        while (j >= 0 && SortAlgorithm.less(last, array[j] ))
        {
            array[j+1] = array[j];
            j--;
        }
        array[j + 1] = last;
        return array;
    }

}
