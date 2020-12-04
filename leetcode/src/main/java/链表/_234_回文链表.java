package 链表;

import java.util.Stack;

/**
 * @author Tiger
 * @date 2020/11/21 17:12
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class _234_回文链表 {

    private ListNode temp;

    public boolean isPalindrome1(ListNode head) {

        temp = head;
        return check(head);
    }

    private boolean check(ListNode head) {
        if (head == null)
            return true;
        boolean res = check(head.next) && (temp.val == head.val);
        temp = temp.next;
        return res;
    }

    public boolean isPalindrome2(ListNode head) {
        if (null == head || null == head.next) {
            return true;
        }
        Stack<Integer> integers = new Stack<>();
        ListNode temp = head;
        int len = 0;
        while (null != head) {
            integers.push(head.val);
            head = head.next;
            len++;
        }
        len = len >> 1;
        while (len-- > 0) {
            if (integers.pop() != temp.val) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    public boolean isPalindrome3(ListNode head) {
        if (null == head || null == head.next) {
            return true;
        }
        ListNode fast = head, slow = head;
        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (null != fast) {
            slow = slow.next;
        }
        fast = head;
        slow = reverseNode(slow);
        while (null != slow) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reverseNode(ListNode head) {
        ListNode newHead = null;
        ListNode next = null;
        while (null != head) {
            next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
