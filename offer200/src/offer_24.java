/**
 * @Author Jinshihong
 * @Date 2020/11/19 10:23
 * @Version 1.0
 */
public class offer_24 {

    public ListNode reverseList(ListNode head) {
        if (head==null) return null;
        else if (head.next==null) return head;
        ListNode pre=head,ord=head.next;
        pre.next=null;

        while (ord!=null){
            ListNode temp=ord.next;
            ord.next=pre;
            pre=ord;
            ord=temp;
        }

        return pre;



    }
}
