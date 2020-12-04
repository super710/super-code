package 数组;

/**
 * @author Tiger
 * @date 2020/11/17 8:55
 * https://leetcode-cn.com/problems/sub-sort-lcci/
 * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
 * 输出： [3,9]
 */
public class 面试题_16_16_部分排序 {
    public static int[] subSort1(int[] array) {
        if (array.length == 0) return new int[]{-1, -1};

        int max = array[0];

        int r = -1;
        for (int i = 1; i < array.length; i++) {

            if (array[i] >= max) {
                max = array[i];
            } else {
                r = i;
            }
        }

        int l = -1;
        int min = array[array.length - 1];
        for (int i = array.length - 1; i >= 0; i--) {

            if (array[i] <= min) {
                min = array[i];
            } else {
                l = i;
            }
        }

        return new int[]{l, r};
    }

    public static int[] subSort2(int[] arr) {
        if (arr == null || arr.length < 2) return new int[]{-1, -1};
        int len = arr.length;

        int i = 0; // find the max from left.
        while (i < len - 1 && arr[i] <= arr[i + 1]) {
            ++i;
        }

        int j = len - 1; // find the min from right
        while (j > 0 && arr[j] >= arr[j - 1]) {
            j--;
        }

        if (j < i) return new int[]{-1, -1};

        int m = i;
        int n = j;

        // ajust the m and n
        for (int k = i; k <= j; ++k) {
            while (m > 0 && arr[k] < arr[m - 1]) {
                m--;
            }

            while (n < len - 1 && arr[k] > arr[n + 1]) {
                n++;
            }
        }
        return new int[]{m, n};
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        subSort2(ints);
    }

    public static int[] test(int[] array) {
        if (null == array || 2 > array.length) {
            return new int[]{-1, -1};
        }
        int length = array.length;
        int max = array[0];
        int min = array[length - 1];
        int l = -1;
        int r = -1;
        for (int i = 1; i < length; i++) {
            if (array[i] >= max) {
                max = array[i];
            } else {
                r = i;
            }
        }
        for (int i = length - 2; i >= 0; i--) {
            if (array[i] <= min) {
                min = array[i];
            } else {
                l = i;
            }
        }
        return new int[]{l, r};
    }
}
