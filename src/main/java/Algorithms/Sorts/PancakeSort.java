package Algorithms.Sorts;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 13/7/18
 * Pancake sort
 * Average performance	O(n^2)
 * Worst-case performance	O(n^2)
 * Best-case performance	O(n^2)
 */

public class PancakeSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            T max = array[0];
            int index = 0;
            for (int j = 0; j < length - i; j++) {
                if (SortAlgorithm.less(max, array[j])) {
                    max = array[j];
                    index = j;
                }
            }
            flip(array, index, length - 1 - i);
        }
        return array;
    }

    private <T extends Comparable<T>> void flip(T[] array, int left, int right) {
        while (left <= right) {
            SortAlgorithm.swap(array, left++, right--);
        }
    }

}
