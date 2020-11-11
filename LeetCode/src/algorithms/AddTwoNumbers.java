package algorithms;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/10
 */

public class AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    /**
     * 2.两数相加
     */

    /**
     * 选择一个链表进行遍历，遍历的过程中将两个链表对应位置的数a，b和标志位d相加，如果相加超过10，将该数
     * 减10放入新的ListNode中，并将标志位d置1，否则将标志位d置0，如果当前链表便利完之后，另一个链表没有
     * 遍历完，按照相同的方法去遍历另外的链表，两个链表遍历完毕，如果d=1，就新建个节点val=d
     *
     *
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a = 0, b = 0, d = 0, e = 0;
        ListNode l3 = null;
        ListNode l4 = null;
        if (l1 != null) {
            a = l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            b = l2.val;
            l2 = l2.next;
        }
        e = a + b + d;
        if (e >= 10){
            e = e - 10;
            d = 1;
        }
        //头结点
        l3 = new ListNode(e);
        l4 = l3;
        a = 0;
        b = 0;
        //遍历两个链表
        while (l1 != null) {
            a = l1.val;
            l1 = l1.next;
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            e = a + b + d;
            if (e >= 10){
                e = e - 10;
                d = 1;
            } else {
                d = 0;
            }
            l4.next = new ListNode(e);
            l4 = l4.next;
            a = 0;
            b = 0;
        }
        a = 0;
        b = 0;
        //遍历另一个没有遍历完的链表
        while (l2 != null) {
            b = l2.val;
            l2 = l2.next;
            e = a + b + d;
            if (e >= 10){
                e = e - 10;
                d = 1;
            } else {
                d = 0;
            }
            l4.next = new ListNode(e);
            l4 = l4.next;
        }
        //根据d的值决定要不要添加最后一个节点
        if (d == 1){
            l4.next = new ListNode(d);
        }
        return l3;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = addTwoNumbers(l1, l2);
        while (listNode != null){
            System.out.print(listNode.val);
            listNode = listNode.next;
            if (listNode != null){
                System.out.print(" -> ");
            }
        }
    }
}
