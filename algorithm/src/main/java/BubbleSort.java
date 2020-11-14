import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author Tiger
 * @date 2020/11/11 19:05
 * 冒泡算法 平局时间复杂度O(n^2)  最好时间复杂度O(n) 最坏时间复杂度O(n^2)
 */
@Slf4j(topic = "c.Day03_BubbleSort")
public class BubbleSort {

    private static int[] ints = new int[]{2, 1, 5, 0, 4, 7, 8, 9};

    public static void main(String[] args) {

        bubbleSort_3();
        log.debug("{}", Arrays.toString(ints));
    }

    /**
     * 原始冒泡排序
     */
    private static void bubbleSort_1() {
        for (int j = ints.length; j > 0; j--) {
            for (int i = 0; i < j - 1; i++) {
                if (ints[i] > ints[i + 1]) {
                    int m = ints[i];
                    ints[i] = ints[i + 1];
                    ints[i + 1] = m;
                }
            }
        }
    }

    /**
     * 加入一个判断位，如果序列已经完全有序，则提前终止冒泡排序
     */
    private static void bubbleSort_2() {
        for (int j = ints.length; j > 0; j--) {
            boolean flag = true;
            for (int i = 0; i < j - 1; i++) {
                if (ints[i] > ints[i + 1]) {
                    int m = ints[i];
                    ints[i] = ints[i + 1];
                    ints[i + 1] = m;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    /**
     * 如果序列尾部已经局部有序，可以记录最后一次交换的位置，减少比较次数
     */
    private static void bubbleSort_3() {
        for (int j = ints.length - 1; j > 0; j--) {
            int sortIndex = 1;
            for (int i = 1; i <= j; i++) {
                if (ints[i] < ints[i - 1]) {
                    int m = ints[i];
                    ints[i] = ints[i - 1];
                    ints[i - 1] = m;
                    sortIndex = i;
                }
            }
            j = sortIndex;
        }
    }
}
