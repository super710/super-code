package offer;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/29
 */
public class FanZhuanLianBiaoLcof {

    /**
     * 剑指 Offer 24. 反转链表
     */

    /**
     * 一次循环反转，使用双指针，一个指向头结点head，一个指向下一个节点next，先保存
     * 一个temp = next.next，然后让next.next = head，head = next， next = temp
     * 直到next为空，链表反转完毕
     */

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        while (next != null){
            ListNode temp = next.next;
            next.next = head;
            head = next;
            next = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        System.out.println(reverseList(l));
    }
}
