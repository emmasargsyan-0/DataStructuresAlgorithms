package Algorithms.Sorts;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 14/7/18
 * Counting sort
 * Average performance	O(n + k) where k is the range of the non-negative key values
 * Worst-case performance	O(n + k) where k is the range of the non-negative key values
 * Best-case performance	O(n + k) where k is the range of the non-negative key values
 */

import java.util.*;

public class CountingSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array){
        return sortList(Arrays.asList(array)).toArray(array);
    }

    private <T extends Comparable<T>> List<T> sortList(List<T> list) {

        Map<T, Integer> frequency = new TreeMap<>();
        List<T> sortedArray = new ArrayList<>(list.size());

        list.forEach(v -> frequency.put(v, frequency.getOrDefault(v, 0) + 1));

        for (Map.Entry<T, Integer> element : frequency.entrySet()) {
            for (int j = 0; j < element.getValue(); j++) {
                sortedArray.add(element.getKey());
            }
        }

        return sortedArray;
    }

}
