package 链表;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Tiger
 * @date 2020/11/19 19:45
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class _160_相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = (null == curA) ? headB : curA.next;
            curB = (null == curB) ? headA : curB.next;
        }
        return headA;
    }

}
