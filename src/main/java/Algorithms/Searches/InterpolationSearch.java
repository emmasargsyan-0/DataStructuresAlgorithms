package Algorithms.Searches;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 10/7/18
 * Interpolation search
 * Average performance	O(log(log(n))) or O(n)
 * Worst-case performance	O(n)
 * Best-case performance	O(1)
 */

class InterpolationSearch{

    public <T extends Comparable<T>> int find(int[] array, int key) {
        int start = 0, end = (array.length - 1);

        while (start <= end && key >= array[start] && key <= array[end]) {
            int pos = start + (((end - start) / (array[end] - array[start])) * (key - array[start]));

            if (array[pos] == key)
                return pos;

            if (array[pos] < key) {
                start = pos + 1;
            } else {
                end = pos - 1;
            }
        }
        return -1;
    }

}
