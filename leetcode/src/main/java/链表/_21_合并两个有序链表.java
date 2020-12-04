package 链表;

/**
 * @author Tiger
 * @date 2020/11/17 22:46
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class _21_合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode preHead = head;
        while (null != l1 && null != l2) {
            if (l1.val >= l2.val) {
                preHead.next = l2;
                l2 = l2.next;
            } else {
                preHead.next = l1;
                l1 = l1.next;
            }
            preHead = preHead.next;
        }
        preHead.next = l1 == null ? l2 : l1;
        return head.next;
    }
}
