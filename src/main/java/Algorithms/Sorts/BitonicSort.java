package Algorithms.Sorts;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 14/7/18
 * Bitonic sort
 * Average performance	O(log(n)^2)
 * Worst-case performance	O(log(n)^2)
 * Best-case performance	O(log(n)^2)
 */

public class BitonicSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        bitonicSort(array, 0, array.length, 1);
        return array;
    }

    private <T extends Comparable<T>> void bitonicMerge(T[] array, int left, int cnt, int direction) {
        if (cnt > 1)
        {
            int tmp = cnt/2;
            for (int i = left; i < left + tmp; i++){
                if ( (SortAlgorithm.less(array[i + tmp], array[i]) && direction == 1) ||
                        (SortAlgorithm.less(array[i], array[i + tmp]) && direction == 0)) {
                    SortAlgorithm.swap(array, i, i + tmp);
                }
            }
            bitonicMerge(array, left, tmp, direction);
            bitonicMerge(array, left + tmp, tmp, direction);
        }
    }

    private <T extends Comparable<T>> void bitonicSort(T[] array, int left, int cnt, int direction) {
        if (cnt > 1)
        {
            int k = cnt/2;
            bitonicSort(array,left + k, k, 0);
            bitonicSort(array,  left, k, 1);
            bitonicMerge(array, left, cnt, direction);
        }
    }

}
