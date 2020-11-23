package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/23
 */
public class ThreeSum {

    /**
     * 15. 三数之和
     */

    /**
     * 借助set，时间复杂度为O(n^2)，获取的list存入set，防止list重复
     */

    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        HashSet<List<Integer>> sets = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < length; ++i) {
            for (int j = i + 1; j < length; ++j) {
                //判断是否三数之和为0
                if (!set.add(nums[j])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(-nums[i] - nums[j]);
                    //list排序，加入set时防止重复
                    list.sort((a, b) -> a >= b ? 0 : -1);
                    sets.add(list);
                } else {
                    set.remove(nums[j]);
                }
                //将前两个数加入set
                set.add(-nums[i] - nums[j]);
            }
            set.clear();
        }
        return new ArrayList<>(sets);
    }

    /**
     * 先进行数组排序，再使用双指针减少时间复杂度。
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int target = -nums[i];
            int k = length - 1;
            for (int j = i + 1; j < length; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                while (k > j && nums[j] + nums[k] > target){
                    k--;
                }
                if (j == k){
                    break;
                }
                if (nums[j] + nums[k] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    lists.add(list);
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum2(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
