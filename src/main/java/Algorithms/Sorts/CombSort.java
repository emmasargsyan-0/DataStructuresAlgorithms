package Algorithms.Sorts;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 16/7/18
 * Comb sort
 * Average performance	O(n^2), where p is the number of increments
 * Worst-case performance	O(n^2/2^p)
 * Best-case performance	O(n*log(n))
 */

public class CombSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        int length = array.length;
        int gap = length;
        boolean swapped = true;

        while (gap != 1 || swapped) {
            gap = nextGap(gap);
            swapped = false;

            for (int i = 0; i < length - gap; i++) {
                if (SortAlgorithm.less(array[i + gap], array[i])) {
                    swapped = SortAlgorithm.swap(array, i, i + gap);
                }
            }
        }
        return array;
    }

    private int nextGap(int gap) {
        gap = (gap * 10) / 13;
        return Math.max(gap, 1);
    }

}
