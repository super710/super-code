package 数组;

/**
 * @author Tiger
 * @date 2020/11/15 19:24
 * https://leetcode-cn.com/problems/sort-colors/
 */
public class _75_颜色分类 {
    /**
     * 使用了三指针
     *
     * @param nums
     */
    public void sortColors1(int[] nums) {
        int i = 0;
        int left = 0;
        int right = nums.length - 1;
        while (i <= right) {
            if (0 == nums[i]) {
                if (left != i) {
                    swap(i, left, nums);
                }
                left++;
                i++;
            } else if (1 == nums[i]) {
                i++;
            } else {
                swap(i, right, nums);
                right--;
            }
        }
    }

    private void swap(int m, int n, int[] nums) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }


    public void sortColors2(int[] nums) {
        //2 0 2 0 1 1
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (0 == nums[i]) {
                swap(left, i, nums);
                left++;
                i++;
            } else if (1 == nums[i]) {
                i++;
            } else {
                swap(right, i, nums);
                right--;
            }
        }
    }
}
