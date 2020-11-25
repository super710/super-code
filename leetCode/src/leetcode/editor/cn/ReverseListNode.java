package leetcode.editor.cn;

public class ReverseListNode {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ListNode listNode = new ListNode(-1);
        int [] a = {5,4,2,1};
        ListNode node = create(listNode.next, a);
        ListNode node1 = reverseListNode(node);
        System.out.println(node1);
    }

    public static ListNode create(ListNode node, int [] a){
        for (int x:a){
            ListNode node1 = new ListNode(x);
            node1.next = node;
            node = node1;
        }
        return node;
    }

    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }


    public static ListNode reverseListNode(ListNode head){
        ListNode node = head;
        if (null==node||null==node.next){
            return node;
        }
        ListNode pre = null,next = null;
        while (node!=null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}
