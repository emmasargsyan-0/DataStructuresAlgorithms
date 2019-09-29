package DataStructures.Queues;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 6/7/18
 * Array List Queue
 */

import java.util.ArrayList;

public class ArrayListQueue<T> {

    private ArrayList<T> queue = new ArrayList<T>();

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return queue.remove(0);
    }

    public T peekFront() {
        return queue.get(0);
    }

    public T peekBack() {
        return queue.get(size()-1);
    }

    public boolean push(T element) {
        return queue.add(element);
    }

}
