package Algorithms.Sorts;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 13/7/18
 * Circle sort
 * Average performance	O(n*log(n))
 * Worst-case performance	O(n*log(n))
 * Best-case performance	O(n*log(n))
 */

public class CircleSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        while ( doSort(array, 0, array.length-1) ){
        }
        return array;
    }

    private <T extends Comparable<T>> boolean doSort(T[] a, int left, int right)
    {
        boolean swapped = false;
        if (left == right) {
            return false;
        }
        int l = left, r = right;

        while (l < r)
        {
            if (SortAlgorithm.less(a[r], a[l]))
            {
              SortAlgorithm.swap(a, l, r);
              swapped = true;
            }
            l++;
            r--;
        }

        if (l == r)
            if (SortAlgorithm.less(a[r + 1], a[l]))
            {
                SortAlgorithm.swap(a, l, r + 1);
                swapped = true;
            }

        int mid = (right - left) / 2;
        boolean firstHalf = doSort(a, left, left+mid);
        boolean secondHalf = doSort(a, left+mid+1, right);

        return swapped || firstHalf || secondHalf;
    }

}
