package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cy
 * @Description
 * @Date 2020/12/16
 */
public class FuZaLianBiaoDeFuZhiLcof {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 剑指 Offer 35. 复杂链表的复制
     */

    /**
     * 利用map，构建新链表和旧链表的k-v对应，最后构建random指针
     */

    public static Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null){
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        Node newHead = map.get(head);
        temp = head;
        while (temp != null){
            Node node = map.get(temp);
            node.next = map.get(temp.next);
            node.random = map.get(temp.random);
            temp = temp.next;
        }
        return newHead;
    }

    /**
     * 拼接加拆分
     */
    public static Node copyRandomList1(Node head) {
        if (head == null){
            return null;
        }
        Node temp = head;

        //拼接复制节点7->1->2  => 7->7->1->1->2->2
        while (temp != null){
            Node next = temp.next;
            temp.next = new Node(temp.val);
            temp.next.next = next;
            temp = next;
        }
        temp = head;

        //设置random指针
        while (temp != null){
            temp.next.random = temp.random == null ? null : temp.random.next;
            temp = temp.next.next;
        }

        //拆分链表
        Node newHead = head.next;
        temp = newHead;
        while (temp != null){
            if (temp.next != null){
                Node next = temp.next.next;
                Node next1 = head.next.next;
                head.next = next1;
                temp.next = next;
                head = next1;
                temp = next;
            } else {
                head.next = null;
                temp = null;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        Node node = new Node(7);
        node.next = new Node(13);
        node.next.next = new Node(11);
        node.next.next.next = new Node(10);
        node.next.next.next.next = new Node(1);
        node.next.random = node;
        node.next.next.random = node.next.next.next.next;
        node.next.next.next.random = node.next.next;
        node.next.next.next.next.random = node;
        Node node1 = copyRandomList1(node);
        System.out.println(node1);
        node1 = copyRandomList(node);
        System.out.println(node1);
    }
}
