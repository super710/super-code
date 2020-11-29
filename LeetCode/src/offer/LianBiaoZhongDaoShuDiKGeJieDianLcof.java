package offer;


/**
 * @Author cy
 * @Description
 * @Date 2020/11/29
 */
public class LianBiaoZhongDaoShuDiKGeJieDianLcof {

    /**
     * 剑指 Offer 22. 链表中倒数第k个节点
     */

    /**
     * 用两个指针，一个指向头结点，另一个指向第k个节点，同时往后移动，当后面的指针为空输出第一个指针
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode temp = head;
        while (temp != null && k > 0){
            temp = temp.next;
            k--;
        }
        if (k > 0){
            return null;
        }
        while (temp != null){
            head = head.next;
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next = new ListNode(5);
        System.out.println(getKthFromEnd(l1, 7));
    }
}
