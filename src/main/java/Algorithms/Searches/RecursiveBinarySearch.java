package Algorithms.Searches;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 9/7/18
 * Recursive Binary search
 * Average performance	O(log(n))
 * Worst-case performance	O(log(n))
 * Best-case performance	O(1)
 */

class RecursiveBinarySearch implements Algorithms.Searches.SearchAlgorithm {

    @Override
    public  <T extends Comparable<T>> int find(T[] array, T key) {
        return search(array, key, 0, array.length);
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
