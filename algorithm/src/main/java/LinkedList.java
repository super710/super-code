import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Tiger
 * @date 2020/11/12 10:52
 */
@Slf4j(topic = "c.Day04_LinkedList")
public class LinkedList<E> extends AbstractList<E> {

    Node<E> first;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Node<E> {
        Node<E> next;
        E element;
    }

    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E e = node.element;
        node.element = element;
        return e;
    }

    @Override
    public void add(int index, E element) {
        if (0 == index) {
            first = new Node<E>(first, element);
        } else {
            Node<E> prev = node(index - 1);
            prev.next = new Node<E>(prev.next, element);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        Node<E> node = first;
        if (index == 0) {
            first = node.next;
        } else {
            Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next = node.next;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (null == element) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (node.element.equals(element)) {
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=" + size).append(", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (0 != i) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(node.element);
            node = node.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> day04LinkedList = new LinkedList<>();
        day04LinkedList.remove(0);
//        day04LinkedList.add(1);
//        day04LinkedList.add(2);
//        day04LinkedList.add(3);
//        day04LinkedList.add(1,13);
        log.debug("{}", day04LinkedList.toString());
    }
}
