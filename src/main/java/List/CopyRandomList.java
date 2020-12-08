package List;

import java.util.HashMap;
import java.util.Map;

class Node {
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
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 *
 *
 */
public class CopyRandomList {
    public Node copyRandomList(Node head) {
        //hash表存储然后转换
        Map<Node,Node> map =new HashMap<>();
        Node cur =head;
        while (cur!=null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }

        cur =head;

        while (cur!=null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur =cur.next;
        }

        return map.get(head);



    }
}
