package DataStructures.Queues;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 6/7/18
 * Priority Queue
 */

class PriorityQueue<T extends Comparable<T>> {

    private int maxSize;
    private T[] queueArray;
    private int nItems;

    public PriorityQueue(int size) {
        maxSize = size;
        queueArray = (T[])new Object[size];
        nItems = 0;
    }

    public void push(T value) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        if (nItems == 0) {
            queueArray[0] = value;
        } else {
            int j = nItems;
            while (j > 0 && value.compareTo(queueArray[j - 1] ) < 0) {
                queueArray[j] = queueArray[j - 1];
                j--;
            }
            queueArray[j] = value;
        }
        nItems++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return queueArray[--nItems];
    }

    public T peekBack() {
        return queueArray[nItems - 1];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    private boolean isFull() {
        return (nItems == maxSize);
    }

    public int getSize() {
        return nItems;
    }

}
