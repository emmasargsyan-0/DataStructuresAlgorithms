package Algorithms.Sorts;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 9/7/18
 * Insertion sort
 * Average performance	O(n^2)
 * Worst-case performance	O(n^2)
 * Best-case performance	O(n)
 */

public class InsertionSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        for (int i = 1; i < array.length; i++) {

            T key = array[i];
            int j = i - 1;

            while (j >= 0 && SortAlgorithm.less(key, array[j])) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
        return array;
    }

}
