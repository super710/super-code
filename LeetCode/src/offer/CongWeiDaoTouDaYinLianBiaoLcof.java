package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/11
 */


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class CongWeiDaoTouDaYinLianBiaoLcof {

    /**
     * 剑指 Offer 06. 从尾到头打印链表
     */

    /**
     * 将链表里面的数字顺序存入ArrayList中，然后逆序存入数组
     */

    public static int[] reversePrint(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        int[] val = {};
        if(head != null){
            nums.add(head.val);
            while(head.next != null){
                head = head.next;
                nums.add(head.val);
            }
            int size = nums.size();
            val = new int[size];
            for (Integer num : nums) {
                val[--size] = num;
            }
        }
        return val;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(2);
        System.out.println(Arrays.toString(reversePrint(listNode)));
    }
}
