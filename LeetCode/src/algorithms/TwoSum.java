package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/10
 */
public class TwoSum {
    /**
     * 1.两数之和
     */


    /**
     * 利用HashMap，将目标值减nums数组里的结果当做key值，将对应的nums数组下标当做value，循环遍历数组
     * 当map中已经存在key时，将key对应的数组下标和当前数组下标输出
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; ++i){
            //判断是否存在key值
            if (map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }
            //放入key值
            map.put(target - nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 5, 9, 3}, 14)));
    }
}

