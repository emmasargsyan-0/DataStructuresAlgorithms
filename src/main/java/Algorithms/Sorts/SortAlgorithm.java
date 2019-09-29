package Algorithms.Sorts;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 9/7/18
 */

public interface SortAlgorithm {

    <T extends Comparable<T>> T[] sort(T[] array);

    static <T> boolean swap(T[] array, int idx, int idy) {
        T swap = array[idx];
        array[idx] = array[idy];
        array[idy] = swap;
        return true;
    }

    static <T extends Comparable<T>> void flip(T[] array, int left, int right) {
        while (left <= right) {
            swap(array, left++, right--);
        }
    }

    static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    static void print(Object[] toPrint) {
        System.out.println(Arrays.toString(toPrint));
    }

}
