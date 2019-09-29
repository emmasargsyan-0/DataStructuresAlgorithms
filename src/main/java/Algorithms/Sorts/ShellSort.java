package Algorithms.Sorts;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 21/7/18
 * Shell sort
 * Average performance	O(n*log(n))
 * Worst-case performance	O(n^2)
 * Best-case performance	O(n*log(n))
 */

public class ShellSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        int length = array.length;
        int temp = 1;

        while (temp < length / 3) {
            temp = (3 * temp) + 1;
        }

        while (temp >= 1) {
            for (int i = temp; i < length; i++) {
                for (int j = i; j >= temp && SortAlgorithm.less(array[j], array[j - temp]); j -= temp) {
                    SortAlgorithm.swap(array, j, j - temp);
                }
            }

            temp /= 3;
        }

        return array;
    }

}
