package offer;

import java.util.Arrays;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/23
 */
public class DaYinCong1DaoZuiDaDeNWeiShuLcof {

    /**
     * 剑指 Offer 17. 打印从1到最大的n位数
     */

    /**
     * 直接打印 10^n - 1的数组
     */

    public static int[] printNumbers(int n) {
        int m = 0;
        for (int i = 0; i < n; i++) {
            m += 9 * Math.pow(10, i);
        }
        int[] nums = new int[m];
        for (int i = 1; i < m + 1; i++) {
            nums[i - 1] = i;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers(3)));
        System.out.println((int)Math.pow(10, 1));
    }
}
