package 栈_队列;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author Tiger
 * @date 2020/11/25 8:28
 */
public class _左右两边第一个比它大的数 {
    public static void main(String[] args) {
        int[] ints = {3, 2, 1, 6, 0, 5};
        int length = ints.length;
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        for (int i = 0; i < length; i++) {
            rightMax[i] = -1;
            while (!arrayDeque.isEmpty() && ints[arrayDeque.peekFirst()] < ints[i]) {
                rightMax[arrayDeque.pop()] = i;
            }

            leftMax[i] = arrayDeque.isEmpty() ? -1 : arrayDeque.peekFirst();

            arrayDeque.push(i);

        }
        System.out.println(Arrays.toString(leftMax));
        System.out.println(Arrays.toString(rightMax));

        int[] parentIndex = new int[length];
        for (int i = 0; i < length; i++) {
            if (leftMax[i] == -1 && rightMax[i] == -1) {
                parentIndex[i] = -1;
            }
            if (leftMax[i] == -1) {
                parentIndex[i] = rightMax[i];
            } else if (rightMax[i] == -1) {
                parentIndex[i] = leftMax[i];
            } else if (ints[leftMax[i]] < ints[rightMax[i]]) {
                parentIndex[i] = leftMax[i];
            }else {
                parentIndex[i] = rightMax[i];
            }
        }
        System.out.println(Arrays.toString(parentIndex));
    }
}
