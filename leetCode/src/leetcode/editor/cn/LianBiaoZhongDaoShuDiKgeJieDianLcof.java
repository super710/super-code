//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
//它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。 
//
// 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针 
// 👍 106 👎 0

package leetcode.editor.cn;

public class LianBiaoZhongDaoShuDiKgeJieDianLcof {
    private static ListNode head;
    public static void main(String[] args) {
        Solution solution = new LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
        for (int i = 2;i>=1;i--){
            add(i);
        }
        ListNode kthFromEnd = solution.getKthFromEnd(head, 1);
        System.out.println(kthFromEnd);
    }

    public static void add(int a){
        ListNode node  = new ListNode(a);
        node.next = head;
        head = node;
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            int size = 0;
            ListNode head1 = head;
            while (head1!=null){
                head1 = head1.next;
                size++;
            }
            if (size<k){
                return null;
            }
            int a = size-k;
            System.out.println(size);
            while (a>0){
                head = head.next;
                a--;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

//解答成功: 执行耗时:4 ms,击败了13.73% 的Java用户 内存消耗:36.4 MB,击败了79.84% 的Java用户
