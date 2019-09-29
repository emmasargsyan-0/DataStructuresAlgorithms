package DataStructures.Trees;

/**
 * Created by IntelliJ IDEA.
 * User: Emma.Sargsyan
 * Date: 8/7/18
 * Binary Tree
 */

public class BinaryTree<T extends Comparable<T>>  {

    private static class Node<T extends Comparable<T>>  {
        public T data;
        public Node<T> left;
        public Node<T> right;
        public Node<T> parent;
        public Node(T value) {
            data = value;
            left = null;
            right = null;
            parent = null;
        }
    }

    private Node<T> root;

    public BinaryTree() {
        root = null;
    }

    public Node<T> find(T key) {
        Node<T> current = root;
        while (current != null) {
            if (current.data.compareTo(key) > 0) {
                if (current.left == null) {
                    return current;
                }
                current = current.left;
            } else if (current.data.compareTo(key) < 0) {
                if (current.right == null) {
                    return current;
                }
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    public void put(T value) {
        Node<T> newNode = new Node<T>(value);
        if (root == null) {
            root = newNode;
        } else {
            Node<T> parent = find(value);
            if (value.compareTo(parent.data) < 0) {
                parent.left = newNode;
                parent.left.parent = parent;
            } else {
                parent.right = newNode;
                parent.right.parent = parent;
            }
        }
    }

    public boolean remove(T value) {
        Node<T> temp = find(value);
        if (temp.data != value) {
            return false;
        }
        if (temp.right == null && temp.left == null) {
            if (temp == root) {
                root = null;
            }else if (temp.parent.data.compareTo(temp.data) < 0) {
                temp.parent.right = null;
            }else {
                temp.parent.left = null;
            }
            return true;
        } else if (temp.left != null && temp.right != null) {
            Node<T> successor = findSuccessor(temp);
            successor.left = temp.left;
            successor.left.parent = successor;
            if (successor.right != null && successor.parent != temp) {
                successor.right.parent = successor.parent;
                successor.parent.left = successor.right;
                successor.right = temp.right;
                successor.right.parent = successor;
            }
            if (temp == root) {
                successor.parent = null;
                root = successor;
                return true;
            }
            else {
                successor.parent = temp.parent;
                if (temp.parent.data.compareTo(temp.data) < 0) {
                    temp.parent.right = successor;
                } else {
                    temp.parent.left = successor;
                }
                return true;
            }
        }
        else {
            if (temp.right != null) {
                if (temp == root) {
                    root = temp.right;
                    return true;
                }
                temp.right.parent = temp.parent;
                if (temp.data.compareTo(temp.parent.data) < 0) {
                    temp.parent.left = temp.right;
                }else {
                    temp.parent.right = temp.right;
                }
                return true;
            }
            else {
                if (temp == root) {
                    root = temp.left;
                    return true;
                }
                temp.left.parent = temp.parent;
                if (temp.data.compareTo(temp.parent.data) < 0) {
                    temp.parent.left = temp.left;
                }else {
                    temp.parent.right = temp.left;
                }
                return true;
            }
        }
    }

    public Node<T> findSuccessor(Node<T> n) {
        if (n.right == null) {
            return n;
        }
        Node<T> current = n.right;
        Node<T> parent = n.right;
        while (current != null) {
            parent = current;
            current = current.left;
        }
        return parent;
    }

    public void inOrder(Node<T> localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.left);
            System.out.print(localRoot.data + " ");
            inOrder(localRoot.right);
        }
    }

    public void preOrder(Node<T> localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.data + " ");
            preOrder(localRoot.left);
            preOrder(localRoot.right);
        }
    }

    public void postOrder(Node<T> localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.left);
            postOrder(localRoot.right);
            System.out.print(localRoot.data + " ");
        }
    }

}
