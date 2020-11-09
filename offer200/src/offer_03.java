import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author Jinshihong
 * @Date 2020/11/9 9:20
 * @Version 1.0
 *
 *
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class offer_03 {
    public static void main(String[] args) {
       int[] nums={2, 3, 1, 0, 2, 5, 3};
       offer_03 o=new offer_03();
       int result=o.findRepeatNumber2(nums);

       System.out.println(result);

    }

    public int findRepeatNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            if(map.containsKey(i))
                map.put(i,map.get(i)+1);
            else
                map.put(i,1);
        }
        int num=-1;
        for (int key:map.keySet())
            if(map.get(key)>1)
                num=key;


        return num;
    }


    public int findRepeatNumber2(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int repet=-1;
        for (int i:nums) {
            if (!set.add(i)){
                repet = i;
                break;
            }
        }

        return repet;


    }


}



























