package Algorithms.Sorts;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 13/7/18
 * Bogo sort
 * Average performance	O(n*n!)
 * Worst-case performance	O(infinity)
 * Best-case performance	O(n)
 */

import java.util.Random;

public class BogoSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        while (!isSorted(array)) {
            nextPermutation(array);
        }
        return array;
    }

    private <T extends Comparable<T>> boolean isSorted(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (SortAlgorithm.less(array[i + 1], array[i])) {
                return false;
            }
        }
        return true;
    }

    private static <T> void nextPermutation(T[] array) {
        int length = array.length;
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomIndex = i + random.nextInt(length - i);
            SortAlgorithm.swap(array, randomIndex, i);
        }
    }
    
}
