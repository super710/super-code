package 栈_队列;

import java.util.ArrayDeque;

/**
 * @author Tiger
 * @date 2020/11/25 10:26
 * https://leetcode-cn.com/problems/daily-temperatures/
 */
public class _739_每日温度 {
    public static int[] dailyTemperatures(int[] T) {
        int[] ints = new int[T.length];
        for (int i = T.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (true) {
                if (T[j] > T[i]) {
                    ints[i] = j - i;
                    break;
                } else if (ints[j] == 0) {
                    ints[i] = 0;
                    break;
                }
                j = j + ints[j];
            }
        }
        return ints;
    }

    public static int[] dailyTemperatures1(int[] T) {
        ArrayDeque<Integer> integers = new ArrayDeque<>();
        int[] ints = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!integers.isEmpty() && T[i] > T[integers.peek()]) {
                Integer pop = integers.pop();
                ints[pop] = i - pop;
            }
            integers.push(i);
        }
        return ints;
    }

    public static void main(String[] args) {
        dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }
}
