package DataStructures.Lists;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 7/7/18
 * Single Linked List
 */

public class SinglyLinkedList<T> {

    private static class Node<T> {
        T value;
        Node<T> next;
        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node<T> head;

    private void insertHead(T x) {
        Node<T> newNode = new Node<T>(x);
        newNode.next = head;
        head = newNode;
    }

    public void insert(T data, int position) {
        if (position < 0 || position > getSize()) {
            throw new RuntimeException("position less than zero or position more than the count of list");
        } else if (position == 0)
            insertHead(data);
        else {
            Node<T> cur = head;
            Node<T> node = new Node<T>(data);
            for (int i = 1; i < position; ++i) {
                cur = cur.next;
            }
            node.next = cur.next;
            cur.next = node;
        }
    }

    private void deleteHead() {
        if (isEmpty()) {
            throw new RuntimeException("The list is empty!");
        }
        head = head.next;
    }

    public void delete(int position) {
        if (position < 0 ) {
            throw new RuntimeException("Position can not be less than zero");
        } else if (position >= getSize()) {
            throw new RuntimeException("Position can not be more than the count of list");
        }else if (position == 0) {
            deleteHead();
        }else {
            Node<T> cur = head;
            for (int i = 1; i < position; ++i) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public int getSize() {
        if (head == null)
            return 0;
        else {
            Node<T> current = head;
            int size = 1;
            while (current.next != null) {
                current = current.next;
                size++;
            }
            return size;
        }
    }

}
