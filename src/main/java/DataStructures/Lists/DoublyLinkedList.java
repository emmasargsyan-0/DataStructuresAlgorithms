package DataStructures.Lists;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 7/7/18
 * Doubly Linked List
 */

public class DoublyLinkedList<T extends Comparable<T>> {

    private static class Link<T extends Comparable<T>> {
        T value;
        Link<T> next;
        Link<T> previous;
        public Link(T value) {
            this.value = value;
        }
    }

    private Link<T> head;
    private Link<T> tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void insertHead(T x) {
        Link<T> newLink = new Link<T>(x);
        if (isEmpty())
            tail = newLink;
        else
            head.previous = newLink;
        newLink.next = head;
        head = newLink;
    }

    public void insertTail(T x) {
        Link<T> newLink = new Link<T>(x);
        newLink.next = null;
        if (isEmpty()) {
            tail = newLink;
            head = tail;
        } else {
            tail.next = newLink;
            newLink.previous = tail;
            tail = newLink;
        }
    }

    private Link<T> deleteHead() {
        Link<T> temp = head;
        head = head.next;
        head.previous = null;
        if (head == null)
            tail = null;
        return temp;
    }

    private Link<T> deleteTail() {
        Link<T> temp = tail;
        tail = tail.previous;
        tail.next = null;
        if (tail == null) {
            head = null;
        }
        return temp;
    }

    public void delete(T x) {
        Link current = head;
        while (current.value != x) {
            if (current != tail) {
                current = current.next;
            } else {
                throw new RuntimeException("The element to be deleted does not exist!");
            }
        }
        if (current == head)
            deleteHead();
        else if (current == tail)
            deleteTail();
        else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
    }

    public boolean isEmpty() {
        return (head == null);
    }

}
