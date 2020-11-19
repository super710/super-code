/**
 * @Author Jinshihong
 * @Date 2020/11/19 9:55
 * @Version 1.0
 */
public class offer_22 {

    public ListNode getKthFromEnd2(ListNode head, int k) {
        int length=0;
        ListNode p=head;
        while(p!=null)
        {
            length++;
            p=p.next;
        }
        int i=length-k;
        for (int j=0;j<i;j++){
            head=head.next;
        }
        return head;


    }

    public ListNode getKthFromEnd(ListNode head, int k) {
       ListNode i=head,j=head;
       for (int n=0;n<k;n++){
           j=j.next;
       }
        while(j!=null){
            i=i.next;
            j=j.next;
        }

        return i;

    }


}
