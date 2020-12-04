package 剑指Offer;

/**
 * @author Tiger
 * @date 2020/12/3 9:06
 */
public class 合并两个排序的链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode node = new ListNode(Integer.MAX_VALUE);
        ListNode p = node;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 == null) {
            p.next = l2;
        } else {
            p.next = l1;
        }
        return node.next;
    }
}
