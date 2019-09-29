package Algorithms.Searches;

import static java.lang.Math.min;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 10/7/18
 * Exponential search
 * Average performance	O(log(n))
 * Worst-case performance	O(log(n))
 * Best-case performance	O(1)
 */

class ExponentialSearch implements Algorithms.Searches.SearchAlgorithm {

    @Override
    public <T extends Comparable<T>> int find(T[] array, T key) {
        if (array[0] == key) {
            return 0;
        }

        int index = 1;
        while (index < array.length && key.compareTo(array[index]) >= 0) {
            index = index * 2;
        }

        return search(array, key, index/2, min(index, array.length));
    }

    private <T extends Comparable<T>> int search(T[] array, T key, int left, int right){
        if (right < left) {
            return -1;
        }

        int median = (left + right) >>> 1;
        int temp = key.compareTo(array[median]);

        if (temp < 0) {
            return search(array, key, left, median - 1);
        }
        if (temp > 0) {
            return search(array, key, median + 1, right);
        }

        return median;
    }

}
