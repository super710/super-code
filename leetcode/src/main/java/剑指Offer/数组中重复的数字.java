package 剑指Offer;

import java.util.HashSet;

/**
 * @author Tiger
 * @date 2020/11/28 15:04
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class 数组中重复的数字 {
    //    public int findRepeatNumber(int[] nums) {
//        HashSet<Integer> hashSet = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (!hashSet.add(nums[i])) {
//                return nums[i];
//            }
//        }
//        return -1;
//    }
    public int findRepeatNumber(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

}
