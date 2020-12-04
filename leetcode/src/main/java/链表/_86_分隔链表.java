package 链表;

/**
 * @author Tiger
 * @date 2020/11/20 8:03
 * https://leetcode-cn.com/problems/partition-list/
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class _86_分隔链表 {
    public ListNode partition(ListNode head, int x) {
        if (null == head) {
            return null;
        }
        ListNode left = new ListNode(-1);
        ListNode leftLast = left;
        ListNode right = new ListNode(-1);
        ListNode rightLast = right;

        while (null != head) {
            int val = head.val;
            if (val < x) {
                leftLast.next = head;
                leftLast = head;
            } else {
                rightLast.next = head;
                rightLast = head;
            }
            head = head.next;
        }
        rightLast.next = null;
        leftLast.next = right.next;
        return left.next;
    }
}
