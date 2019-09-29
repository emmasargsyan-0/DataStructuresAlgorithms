package DataStructures.Stacks;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 5/7/18
 * Stack Array
 */

public class StackArray<T> {

    private int maxSize;
    private T[] stackArray;
    private int top;

    public StackArray(int size) {
        maxSize = size;
        stackArray = (T[])new Object[size];
        top = -1;
    }

    public void push(T value) {
        if (!isFull()) {
            top++;
            stackArray[top] = value;
        } else {
            throw new RuntimeException("Queue is full");
        }
    }

    public T pop() {
        if (!isEmpty()) {
            return stackArray[top--];
        }else{
            throw new RuntimeException("The stack is empty");
        }
    }

    public T peek() {
        if (!isEmpty()) {
            return stackArray[top];
        } else {
            throw new RuntimeException("The stack is empty");
        }
    }

    public int getSize() {
        return top + 1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    private boolean isFull() {
        return (top + 1 == maxSize);
    }

    public void makeEmpty() {
        top = -1;
    }

}
