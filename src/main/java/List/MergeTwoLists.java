package List;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 */
public class MergeTwoLists {
    /*public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //思路：双指针比较
        //先比较两个链表头结点大小，小的作为头结点
        ListNode head;
        if(l1==null){
            return l2;
        }else if(l2 ==null)
            return l1;

        if(l1.val<l2.val){
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode temp = head;
        //双指针遍历两个链表
        while(l1!=null || l2!=null){
            //当两个链表都还没遍历到尽头
            if(l1!=null&&l2!=null){
                if(l1.val<l2.val) {
                    temp.next = l1;
                    l1 = l1.next;
                }else{
                    temp.next = l2;
                    l2=l2.next;
                }
                temp = temp.next;
            }else if(l1==null){
                //第一个链表遍历到最后节点时，直接在temp最后节点上接上l2就可以返回
                temp.next = l2;
                return head;
            }else {//第二个链表遍历到最后节点时，直接在temp最后节点上接上l1就可以返回
                temp.next = l1;
                return head;
            }

        }
        return head;
    }*/

    //大神代码

        public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dum = new ListNode(0), cur = dum;
            while(l1 != null && l2 != null) {
                if(l1.val < l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                }
                else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            cur.next = l1 != null ? l1 : l2;
            return dum.next;
        }




    public static void main(String[] args) {
        ListNode l1 =new ListNode(-9);
        l1.next=new ListNode(3);


        ListNode l2 =new ListNode(5);
        l2.next=new ListNode(7);


        ListNode listNode = mergeTwoLists(l1, l2);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


    }
}
