package Algorithms.Sorts;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 15/7/18
 * Gnome sort
 * Average performance	O(n^2)
 * Worst-case performance	O(n^2)
 * Best-case performance	O(n)
 */

public class GnomeSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) {
        int i = 1, j = 2;
        while (i < arr.length) {
            if (SortAlgorithm.less(arr[i - 1], arr[i])) {
                i = j++;
            } else {
                SortAlgorithm.swap(arr, i - 1, i);
                if (--i == 0) {
                    i = j++;
                }
            }
        }
        return null;
    }

}
