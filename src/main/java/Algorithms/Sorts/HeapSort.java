package Algorithms.Sorts;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 15/7/18
 * Heap sort
 * Average performance	O(n*log(n))
 * Worst-case performance	O(n*log(n))
 * Best-case performance	O(n)
 */

public class HeapSort implements SortAlgorithm {

    //@Override
    public <T extends Comparable<T>> T[] sort(T[] array)
    {
        int length = array.length;

        for (int i = length / 2 - 1; i >= 0; i--) {
            heapifySubtree(array, length, i);
        }

        for (int i = length - 1; i >= 0; i--)
        {
            SortAlgorithm.swap(array, 0, i);
            heapifySubtree(array, i, 0);
        }
        return array;
    }

    private <T extends Comparable<T>> void heapifySubtree(T[] array, int n, int i) {
        int node = i;
        int left = 2 * node + 1;
        int right = 2 * node + 2;

        if (left < n && SortAlgorithm.less(array[node], array[left])){
            node = left;
        }

        if (right < n &&  SortAlgorithm.less(array[node],array[right])){
            node = right;
        }

        if (node != i)
        {
            SortAlgorithm.swap(array, i, node);
            heapifySubtree(array, n, node);
        }
    }

}
