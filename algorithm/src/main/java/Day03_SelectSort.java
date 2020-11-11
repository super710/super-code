import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author Tiger
 * @date 2020/11/11 21:30
 * 选择算法 平局时间复杂度O(n^2)  最好时间复杂度O(n^2) 最坏时间复杂度O(n^2)
 */
@Slf4j(topic = "c.Day03_SelectSort")
public class Day03_SelectSort {

    private static int[] ints = new int[]{2, 1, 5, 0, 4, 7, 8, 9};

    public static void main(String[] args) {
        selectSort_01(ints);
        log.debug("{}", Arrays.toString(ints));
    }

    /**
     * 原始选择排序
     *
     * @param ints
     */
    private static void selectSort_01(int[] ints) {
        for (int length = ints.length; length > 0; length--) {
            int max = 0;
            for (int i = 1; i < length; i++) {
                if (ints[i] > ints[max]) {
                    max = i;
                }
            }
            int temp = ints[max];
            ints[max] = ints[length - 1];
            ints[length - 1] = temp;
        }
    }
}
