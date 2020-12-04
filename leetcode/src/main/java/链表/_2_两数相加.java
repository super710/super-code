package 链表;

/**
 * @author Tiger
 * @date 2020/11/19 10:15
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class _2_两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode last = dummyHead;
        int carry = 0;
        while (null != l1 || null != l2) {
            int v1 = 0;
            int v2 = 0;
            if (null != l1) {
                v1 = l1.val;
                l1 = l1.next;
            }
            if (null != l2) {
                v2 = l2.val;
                l2 = l2.next;
            }
            int m = v1 + v2 + carry;
            last.next = new ListNode(m % 10);
            carry = m / 10;
            last = last.next;
        }
        if (0 < carry) {
            last.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
