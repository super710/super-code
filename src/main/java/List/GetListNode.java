package List;

import java.util.Stack;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，
 * 它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 *
 */



public class GetListNode {
    //思路：栈
    public ListNode getKthFromEnd(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        int number=0;
        while(head!=null) {
            stack.push(head);//依次入栈直到尾节点。
            head = head.next;
            number++;
        }

        int count =0;
        while(true){
            count++;
            ListNode temp = stack.pop();
            if(count==k)
                return temp;
            if(count==number)
                throw new RuntimeException("越界");
        }

        /**
         * 大佬的代码
         * ListNode former = head, latter = head;
         *         for(int i = 0; i < k; i++)
         *             former = former.next;
         *         while(former != null) {
         *             former = former.next;
         *             latter = latter.next;
         *         }
         *         return latter;
         *
         */

    }



    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        System.out.println(4);
    }
}
