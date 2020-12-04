package 剑指Offer;

import java.util.Arrays;

/**
 * @author Tiger
 * @date 2020/12/1 10:30
 */
public class 调整数组顺序使奇数位于偶数前面 {
//    public static int[] exchange(int[] nums) {
//        int left = 0;
//        int right = nums.length - 1;
//        int temp;
//        while (left < right) {
//            while ((nums[left] & 1) != 0 && left < right) {
//                left++;
//            }
//            while ((nums[right] & 1) == 0 && left < right) {
//                right--;
//            }
//            if (left < right) {
//                temp = nums[right];
//                nums[right] = nums[left];
//                nums[left] = temp;
//            }
//        }
//        return nums;
//    }

    public static int[] exchange(int[] nums) {
        int p = 0;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                temp = nums[i];
                nums[i] = nums[p];
                nums[p++] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(exchange(new int[]{1, 2, 3, 4})));
    }
}
