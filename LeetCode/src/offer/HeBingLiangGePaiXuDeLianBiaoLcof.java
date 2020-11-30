package offer;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/30
 */
public class HeBingLiangGePaiXuDeLianBiaoLcof {

    /**
     * 剑指 Offer 25. 合并两个排序的链表
     */

    /**
     * 使用双指针，比较两个val值得大小，将小的放在前面
     * 为了使代码更简洁，可以引入伪头结点，返回伪头结点.next即可
     */

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode head = l1;
        if (l1.val > l2.val){
            head = l2;
            l2 = l2.next;
        } else {
            l1 = l1.next;
        }
        ListNode temp = head;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 != null){
            temp.next = l1;
        }
        if (l2 != null){
            temp.next = l2;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println(mergeTwoLists(l1, l2));
    }
}
