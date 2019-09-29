package DataStructures.Lists;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 7/7/18
 * Circle Linked List
 */

public class CircleLinkedList<T> {

    private static class Node<T> {
        Node<T> next;
        T value;

        private Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private int size;
    private Node<T> head;

    public CircleLinkedList() {
        head = new Node<T>(null, head);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void append(T value) {
        if (value == null) {
            throw new NullPointerException("Cannot add null element to the list");
        }
        head.next = new Node<T>(value, head);
        size++;
    }

    public T remove(int pos) {
        if (pos > size) {
            throw new IndexOutOfBoundsException("Position cannot be greater than size");
        }else if ( pos < 0){
            throw new IndexOutOfBoundsException("Position cannot be negative");
        }
        Node<T> iterator = head.next;
        Node<T> before = head;
        for (int i = 1; i <= pos; i++) {
            iterator = iterator.next;
            before = before.next;
        }
        T saved = iterator.value;
        before.next = iterator.next;
        iterator.next = null;
        iterator.value = null;
        return saved;
    }

}

