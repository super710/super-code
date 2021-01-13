package offer;

import java.util.Arrays;

/**
 * @Author cy
 * @Description
 * @Date 2021/1/13
 */
public class ZuiXiaoDeKGeShuLcof {

    /**
     * 剑指 Offer 40. 最小的k个数
     */

    /**
     * 直接掉用系统跑排序算法，取前k个数，也可以使用大根堆或快排实现
     */

    public static int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] arr1 = new int[k];
        System.arraycopy(arr, 0, arr1, 0, k);
        return arr1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getLeastNumbers(new int[]{3, 2, 1}, 2)));
    }
}
