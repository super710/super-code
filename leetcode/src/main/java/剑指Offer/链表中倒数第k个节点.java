package 剑指Offer;

/**
 * @author Tiger
 * @date 2020/12/2 9:08
 */
public class 链表中倒数第k个节点 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode slow = head;
        int i;
        for (i = 1; i <= k; i++) {
            if (slow == null && i <= k) {
                return null;
            }
            slow = slow.next;
        }

        slow = head;
        ListNode fast = head;
        i = 0;
        while (fast != null) {
            if (i >= k) {
                slow = slow.next;
            }
            fast = fast.next;
            i++;
        }
        return slow;
    }

//    public ListNode getKthFromEnd(ListNode head, int k) {
//        if (head == null || k <= 0) {
//            return null;
//        }
//        ListNode reverseHead = reverseList(head);
//        head = reverseHead;
//        int i;
//        for (i = 1; (i <= k - 1) && head != null; i++) {
//            head = head.next;
//        }
//        if (i < k - 1 || head == null) {
//            return null;
//        } else {
//            head.next = null;
//            return reverseList(reverseHead);
//        }
//    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
