package offer;

import java.util.Arrays;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/26
 */
public class TiaoZhengShuZuShunXuLcof {

    /**
     * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
     */

    /**
     * 使用双指针，一个从0开始，一个从nums.length - 1开始，各自循环增加，当前面的
     * 指针遇到偶数时停止，后面的指针遇到奇数时停止，此时交换两数，继续循环
     */

    public static int[] exchange(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end){
            //代码冗余，放在两个while下面可以去掉if判断条件
            if (nums[start] % 2 == 0 && nums[end] % 2 == 1){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
            while (start < end && nums[start] % 2 == 1){
                start++;
            }
            while (start < end && nums[end] % 2 == 0){
                end--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(exchange(new int[]{1, 2, 3, 4})));
    }
}
