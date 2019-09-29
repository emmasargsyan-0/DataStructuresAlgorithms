package Algorithms.Sorts;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 14/7/18
 * Cocktail Shaker sort
 * Average performance	O(n^2)
 * Worst-case performance	O(n^2)
 * Best-case performance	O(n)
 */

public class CocktailShakerSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        int length = array.length;
        int left = 0, right = length - 1;
        int l, r;
        while (left < right) {
            r = 0;
            for (int i = left; i < right; i++) {
                if (SortAlgorithm.less(array[i + 1], array[i])) {
                    SortAlgorithm.swap(array, i, i + 1);
                    r = i;
                }
            }
            right = r;
            l = length - 1;
            for (int j = right; j > left; j--) {
                if (SortAlgorithm.less(array[j], array[j - 1])) {
                    SortAlgorithm.swap(array, j - 1, j);
                    l = j;
                }
            }
            left = l;
        }
        return array;
    }

}
