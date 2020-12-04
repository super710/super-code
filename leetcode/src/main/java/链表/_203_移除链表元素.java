package 链表;

/**
 * @author Tiger
 * @date 2020/11/19 8:49
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class _203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        if (null == head){
            return head;
        }
        ListNode h = new ListNode(-1,head);
        ListNode w = h;
        while (null!=h.next){
            if (val == h.next.val){
                h.next = h.next.next;
            }else {
                h = h.next;
            }
        }
        return w.next;
    }
}
