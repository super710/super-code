package 数组;

/**
 * @author Tiger
 * @date 2020/12/2 8:25
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class _283_移动零 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        int j = 0;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }
}
