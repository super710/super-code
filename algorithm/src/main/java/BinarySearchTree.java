/**
 * @author Tiger
 * @date 2020/11/14 10:24
 */
public class BinarySearchTree<E> {
    private int size;
    private Node<E> root;

    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }

    private void elementNotNullCheck(E element) {
        if (null == element) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {

    }

    public void add(E element) {
        elementNotNullCheck(element);
        if (null == root) {
            root = new Node<>(element, null);
            size++;
            return;
        }
        Node<E> node = root;
        Node<E> parent = root;
        int cmp = 0;
        while (node != null) {
            parent = node;
            cmp = compare(element, node.element);
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                return;
            }
        }
        Node<E> eNode = new Node<>(element, parent);
        if (cmp > 0) {
            parent.right = eNode;
        } else {
            parent.left = eNode;
        }
        size++;
    }

    private int compare(E e1, E e2) {
        return 0;
    }

    public void remove(E element) {

    }

    public boolean contains(E element) {
        return false;
    }
}
