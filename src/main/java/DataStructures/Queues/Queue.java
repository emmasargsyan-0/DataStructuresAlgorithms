package DataStructures.Queues;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 5/7/18
 * Queue
 */

class Queue<T> {

    private int maxSize;
    private T[] queueArray;
    private int front;
    private int back;
    private int numberOfItems;

    public Queue(int size) {
        maxSize = size;
        queueArray = (T[])new Object[size];
        front = 0;
        back = -1;
        numberOfItems = 0;
    }

    public boolean push(T x) {
        if (isFull()){
            throw new RuntimeException("Queue is full");
        }
        if (back == maxSize - 1) {
            back = -1;
        }
        back++;
        queueArray[back] = x;
        numberOfItems++;
        return true;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T temp = queueArray[front];
        front++;
        if (front == maxSize)
            front = 0;
        numberOfItems--;
        return temp;
    }

    public T peekFront() {
        return queueArray[front];
    }

    public T peekBack() {
        return queueArray[back];
    }

    public boolean isEmpty() {
        return (numberOfItems == 0);
    }

    private boolean isFull() {
        return (numberOfItems == maxSize);
    }

    public int getSize() {
        return numberOfItems;
    }

}
