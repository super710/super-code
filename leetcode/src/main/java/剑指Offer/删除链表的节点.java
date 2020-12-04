package 剑指Offer;

/**
 * @author Tiger
 * @date 2020/12/1 9:52
 */
public class 删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        if (null == head) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
                return head;
            }
            p = p.next;
        }
        return null;
    }
}
