package Algorithms.Sorts;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 11/7/18
 * Bubble sort
 * Average performance	O(n^2)
 * Worst-case performance	O(n^2)
 * Best-case performance	O(n)
 */

public class BubbleSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        int length = array.length;

        for (int i = 0; i < (length - 1); i++) {
            for (int j = 0; j < (length - i - 1); j++) {
                if ( array[j + 1].compareTo( array[j] ) < 0 ) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;
    }

}
