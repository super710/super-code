package 链表;

/**
 * @author Tiger
 * @date 2020/11/20 10:00
 * https://leetcode-cn.com/problems/split-linked-list-in-parts/
 */
public class _725_分隔链表 {
    public ListNode[] splitListToParts1(ListNode root, int k) {
        if (null == root) {
            return new ListNode[k];
        }
        ListNode head = root;
        int size = 0;
        while (null != head) {
            size++;
            head = head.next;
        }
        int slip = size / k;
        int u = size % k;
        ListNode[] listNodes = new ListNode[k];
        head = root;
        for (int i = 0; i < k && null != head; i++) {
            listNodes[i] = head;
            size = slip + (u-- > 0 ? 1 : 0);
            for (int j = 0; j < size - 1; j++) {
                head = head.next;
            }
            ListNode next = head.next;
            head.next = null;
            head = next;
        }
        return listNodes;
    }

    public ListNode[] splitListToParts2(ListNode root, int k) {
        int n = 0;
        ListNode cur = root;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        int mod = n % k;
        int size = n / k;
        ListNode[] res = new ListNode[k];
        cur = root;
        for (int i = 0; i < k && cur != null; i++) {
            res[i] = cur;
            int cursize = size + (mod-- > 0 ? 1 : 0);
            for (int j = 0; j < cursize - 1; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return res;
    }
}
