package Algorithms.Searches;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 9/7/18
 * Linear search
 * Average performance	O(n)
 * Worst-case performance	O(n)
 * Best-case performance	O(1)
 */

public class LinearSearch implements Algorithms.Searches.SearchAlgorithm {

    @Override
    public <T extends Comparable<T>> int find(T[] array, T value) {
        for (int ind = 0; ind < array.length; ind++) {
            if (array[ind].compareTo(value) == 0) {
                return ind;
            }
        }
        return -1;
    }

}
