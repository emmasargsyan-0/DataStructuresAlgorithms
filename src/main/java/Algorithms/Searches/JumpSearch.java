package Algorithms.Searches;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 11/7/18
 * Jump search
 * Average performance	O(sqrt(n))
 * Worst-case performance	O(sqrt(n))
 * Best-case performance	O(1)
 */

class JumpSearch implements Algorithms.Searches.SearchAlgorithm {

    @Override
    public <T extends Comparable<T>> int find(T[] array, T key) {
        int length = array.length;
        int step = (int)Math.floor(Math.sqrt(length));
        int prev = 0;

        while (key.compareTo(array[Math.min(step, length)-1]) > 0)
        {
            prev = step;
            step += (int)Math.floor(Math.sqrt(length));
            if (prev >= length)
                return -1;
        }

        while (key.compareTo(array[prev]) > 0)
        {
            prev++;
            if (prev == Math.min(step, length))
                return -1;
        }

        if (array[prev] == key) {
            return prev;
        }

        return -1;
    }

}
