package Algorithms.Searches;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 9/7/18
 * Binary search
 * Average performance	O(log(n))
 * Worst-case performance	O(log(n))
 * Best-case performance	O(1)
 */

class BinarySearch implements Algorithms.Searches.SearchAlgorithm {

    @Override
    public <T extends Comparable<T>> int find(T[] array, T key) {
        int left, right, index;

        left = 0;
        right = array.length - 1;

        while (left <= right) {
            index = (left + right) / 2;
            int cmp = key.compareTo(array[index]);

            if (cmp == 0) {
                return index;
            } else if (cmp < 0) {
                right = --index;
            } else {
                left = ++index;
            }
        }

        return -1;
    }

}
