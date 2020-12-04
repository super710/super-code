package 剑指Offer;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Tiger
 * @date 2020/11/28 15:45
 */
public class 从尾到头打印链表 {
    //栈
//    public int[] reversePrint(ListNode head) {
//        ArrayDeque<Integer> integers = new ArrayDeque<>();
//        while (head != null) {
//            integers.push(head.val);
//            head = head.next;
//        }
//        int size = integers.size();
//        int[] ints = new int[size];
//        for (int i = 0; i < size; i++) {
//            ints[i] = integers.pop();
//        }
//        return ints;
//    }

    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> integers = new ArrayList<>();
        reverse(head, integers);
        int size = integers.size();
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = integers.get(i);
        }
        return ints;
    }

    private void reverse(ListNode head, ArrayList<Integer> integers) {
        if (head.next != null) {
            reverse(head.next, integers);
        }
        integers.add(head.val);
    }
}
