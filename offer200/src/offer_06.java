import java.util.Stack;

/**
 * @Author Jinshihong
 * @Date 2020/11/9 10:00
 * @Version 1.0
 *
 *  * Definition for singly-linked list.
 *  * public class ListNode {
 *  *     int val;
 *  *     ListNode next;
 *  *     ListNode(int x) { val = x; }
 *  * }
 *
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。



示例 1：

输入：head = [1,3,2]
输出：[2,3,1]

示例 1：

输入：head = [1,3,2]
输出：[2,3,1]
 

限制：

0 <= 链表长度 <= 10000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class offer_06 {
    public static void main(String[] args) {

    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack=new Stack<>();
        ListNode node=head;
        while(node!=null){
            stack.push(node.val);
            node=node.next;
        }
        int len=stack.size();
        int [] result=new int[len];
        for (int i=0;i<len;i++){
            result[i]=stack.pop();
        }




        return result;
    }




}
