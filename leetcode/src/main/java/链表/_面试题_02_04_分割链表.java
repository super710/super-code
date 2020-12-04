package 链表;

/**
 * @author Tiger
 * @date 2020/11/20 9:30
 * https://leetcode-cn.com/problems/partition-list-lcci/
 */
public class _面试题_02_04_分割链表 {
    public ListNode partition(ListNode head, int x) {
        ListNode iHead = new ListNode(-1);
        ListNode iTail = iHead;
        ListNode rHead = new ListNode(-1);
        ListNode rTail = rHead;

        while (null != head) {
            int val = head.val;
            if (val < x) {
                iTail.next = head;
                iTail = head;
            } else {
                rTail.next = head;
                rTail = head;
            }
            head = head.next;
        }
        rTail.next = null;
        iTail.next = rHead.next;
        return iHead.next;
    }
}
