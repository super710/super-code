package 链表;

/**
 * @author Tiger
 * @date 2020/11/12 20:15
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class 剑指_Offer_24_反转链表 {

    /**
     * 递归实现  很魔幻
     *
     * @param head 头结点
     * @return 返回新的头结点
     */
    public ListNode reverseList1(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 迭代实现
     *
     * @param head 头结点
     * @return 返回新的头结点
     */
    public ListNode reverseList2(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode newHead = null;
        while (null != head) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
