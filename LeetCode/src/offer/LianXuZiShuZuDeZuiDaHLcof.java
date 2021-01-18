package offer;

/**
 * @Author cy
 * @Description
 * @Date 2021/1/18
 */
public class LianXuZiShuZuDeZuiDaHLcof {

    /**
     * 剑指 Offer 42. 连续子数组的最大和
     */

    /**
     * 使用动态规划，维护一个数组，最后得出数组里面最大数，可以进行空间优化，利用
     * 两个变量代替数组，一个保存dp中最大的值，一个保存dp[i]的值
     */

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //前面的子串大于0，则对最大子串有贡献，加起来
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                //前面的子串小于0，则对最大子串没有贡献，不用考虑
                dp[i] = nums[i];
            }
        }
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
