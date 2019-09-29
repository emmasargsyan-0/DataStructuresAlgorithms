package Algorithms.Sorts;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 16/7/18
 * Cycle sort
 * Average performance	O(n^2)
 * Worst-case performance	O(n^2)
 * Best-case performance	O(n^2)
 */

public class CycleSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        int length = array.length;

        for (int cycle_start = 0; cycle_start <= length - 2; cycle_start++) {
            T item = array[cycle_start];

            int pos = cycle_start;
            for (int i = cycle_start + 1; i < length; i++) {
                if (SortAlgorithm.less(array[i], item)) {
                    pos++;
                }
            }

            if (pos == cycle_start) {
                continue;
            }

            while (item == array[pos]){
                pos += 1;
            }

            if (pos != cycle_start) {
                T temp = item;
                item = array[pos];
                array[pos] = temp;
            }

            while (pos != cycle_start) {
                pos = cycle_start;

                for (int i = cycle_start + 1; i < length; i++) {
                    if (SortAlgorithm.less(array[i], item)) {
                        pos += 1;
                    }
                }

                while (item == array[pos]) {
                    pos += 1;
                }

                if (item != array[pos]) {
                    T temp = item;
                    item = array[pos];
                    array[pos] = temp;
                }
            }
        }
        return  array;
    }

}
