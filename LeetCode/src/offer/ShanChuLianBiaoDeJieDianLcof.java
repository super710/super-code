package offer;

import algorithms.AddTwoNumbers;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/23
 */
public class ShanChuLianBiaoDeJieDianLcof {

    /**
     * 剑指 Offer 18. 删除链表的节点
     */

    /**
     * 如果头结点等于所传的值，返回头结点的next节点，否则遍历整个链表，发现相等节点的就将
     * 该节点的前一个节点的next指向该节点的next节点。
     */

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteNode(ListNode head, int val) {
        ListNode listNode = head;
        if (head.val == val){
            return head.next;
        }
        while (listNode != null){
            if (listNode.next != null && listNode.next.val == val){
                listNode.next = listNode.next.next;
                return head;
            }
            listNode = listNode.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(9);
        ListNode listNode = deleteNode(l1, 1);
        System.out.println(listNode);
    }
}
