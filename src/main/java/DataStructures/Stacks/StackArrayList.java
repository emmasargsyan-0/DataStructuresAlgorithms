package DataStructures.Stacks;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 5/7/18
 * Stack Array List
 */

import java.util.ArrayList;

public class StackArrayList<T> {

    private ArrayList<T> stackList = new ArrayList<T>();

    public StackArrayList() {
    }

    public void push(T value) {
        stackList.add(value);
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T popValue = stackList.get(stackList.size() - 1);
        stackList.remove(stackList.size() - 1);
        return popValue;
    }

    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    public int size() {
        return stackList.size();
    }

    public T peek() {
        return stackList.get(stackList.size() - 1);
    }

}
