package Algorithms.Searches;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 9/7/18
 */

public interface SearchAlgorithm {

    <T extends Comparable<T>> int find(T[] array, T key);

}
