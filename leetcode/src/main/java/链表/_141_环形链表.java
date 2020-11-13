package 链表;

import java.util.HashSet;

/**
 * @author Tiger
 * @date 2020/11/12 21:29
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class _141_环形链表 {
    public boolean hasCycle1(ListNode head) {
        //快慢指针
        ListNode fastNode = null;
        if (null == head || null == (fastNode = head.next)) {
            return false;
        }
        while (null != fastNode && null != fastNode.next) {

            head = head.next;
            fastNode = fastNode.next.next;
            if (fastNode == head) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        HashSet<ListNode> listNodes = new HashSet<>();
        while (null != head) {
            if (listNodes.contains(head)) {
                return true;
            }
            listNodes.add(head);
            head = head.next;
        }
        return false;
    }
}
