package 链表;

/**
 * @author Tiger
 * @date 2020/11/12 20:00
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class _237_删除链表中的节点 {

    public void deleteNode(ListNode node) {
        //讲道理 这题就是个脑筋急转弯
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
