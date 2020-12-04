package 栈_队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Tiger
 * @date 2020/11/23 9:21
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 */
public class _剑指_Offer_59_I_滑动窗口的最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k < 1) {
            return new int[0];
        }
        if (1 == k) {
            return nums;
        }
        int length = nums.length;
        int[] maxes = new int[length - k + 1];
        int maxIdx = 0;
        for (int i = 1; i < k; i++) {
            if (nums[i] >= nums[maxIdx]) {
                maxIdx = i;
            }
        }
        for (int i = 0; i < length - k + 1; i++) {
            int r = i + k - 1;
            if (maxIdx < i) {
                maxIdx = i;
                for (int l = i+1; l <= r; l++) {
                    if (nums[l] >= nums[maxIdx]) {
                        maxIdx = l;
                    }
                }
            } else if (nums[r] >= nums[maxIdx]) {
                maxIdx = r;
            }
            maxes[i] = nums[maxIdx];
        }
        return maxes;
    }

    public int[] maxSlidingWindowDeque(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k < 1) {
            return new int[0];
        }
        if (1 == k) {
            return nums;
        }

        int length = nums.length;
        int[] maxes = new int[length - k + 1];

        Deque<Integer> integers = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            while (!integers.isEmpty() && nums[integers.peekLast()] <= num) {
                integers.pollLast();
            }
            integers.offerLast(i);
            int w = i - k + 1;
            if (w < 0) {
                continue;
            }
            if (integers.peekFirst() < w) {
                integers.pollFirst();
            }
            maxes[w] = nums[integers.peekFirst()];
        }
        return maxes;
    }
}
