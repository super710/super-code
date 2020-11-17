/**
 * @Author Jinshihong
 * @Date 2020/11/17 9:37
 * @Version 1.0
 */

public class offer_18 {

    public ListNode deleteNode(ListNode head, int val) {

        if (head.val==val){
            head=head.next;
            return head;
        }

        ListNode p=head;
        ListNode node=p.next;
        while(node!=null){
            if (node.val==val)
            {
                p.next=node.next;
                node=node.next;
            }
            else
            {
                p=node;
                node=node.next;
            }


        }

        return head;
    }


}
