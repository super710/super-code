package Array;

import org.junit.Test;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *  
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];//dp数组表示当前位置的所有子数组的和的最大值
        int max = dp[0]=nums[0];
        for (int i = 1;i<nums.length;i++){
            if(dp[i-1]>0){
                dp[i]=dp[i-1]+nums[i];
            }else
                dp[i]=nums[i];

            if(dp[i]>max)
                max = dp[i];
        }
        return max;


    }

    @Test
    public void test(){
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
