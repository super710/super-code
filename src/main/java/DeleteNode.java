


//题目：给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class DeleteNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next=new ListNode(5);
        head.next.next=new ListNode(1);
        head.next.next.next=new ListNode(9);
        ListNode node = deleteNode(head, 5);
        while (node!=null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static ListNode deleteNode(ListNode head, int val) {
       //判空
        if(head ==null)
            return null;
        //如果寻找的值是头结点
        if(head.val==val)
            return head.next;

        //如果不是头结点，则头结点不动，定义辅助节点
        ListNode temp = head;
        while (temp.next!=null){
            if(temp.next.val==val){
                temp.next = temp.next.next;
                return head;
            }
            temp = temp.next;
        }
        throw new RuntimeException("no");
    }
}
