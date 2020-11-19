/**
 * @Author Jinshihong
 * @Date 2020/11/19 10:57
 * @Version 1.0
 */
public class offer_25 {

    public static void main(String[] args) {
        offer_25 o=new offer_25();

    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum=new ListNode(0);
        ListNode cur=dum;
        while(l1!=null&&l2!=null){
            if (l1.val<=l2.val)
            {
                cur.next=l1;
                l1=l1.next;
            }
            else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        if (l1==null)  cur.next=l2;
        if (l2==null)  cur.next=l1;
        return dum.next;

    }

}
