package Array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {



    public int majorityElement(int[] nums) {
       /* //hashmap统计各数字的数量
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if(map.get(num)!=null)
                map.put(num,map.get(num)+1);
            else
                map.put(num,1);
        }

        int maxValue =0;
        int maxKey=0;
        for (Integer integer : map.keySet()) {
           if(map.get(integer)>maxValue) {
               maxValue = map.get(integer);
               maxKey = integer;
           }
        }

        return maxKey;*/

        //数组排序法

        //摩尔投票法
        /**
         * 推论一： 若记 众数 的票数为 +1+1 ，非众数 的票数为 -1−1 ，则一定有所有数字的 票数和 > 0>0 。
         *
         * 推论二： 若数组的前 aa 个数字的 票数和 = 0=0 ，则 数组剩余 (n-a)(n−a) 个数字的 票数和一定仍 >0>0 ，即后 (n-a)(n−a) 个数字的 众数仍为 xx 。
         *
         */
        int x = 0, votes = 0, count = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        // 验证 x 是否为超过一半的众数
        for(int num : nums)
            if(num == x) count++;
        return count > nums.length / 2 ? x : 0; // 当无众数时返回 0




    }

    @Test
    public void test(){
        int[] nums = {2,1,2,0,2,4,3,3};
        int i = majorityElement(nums);
        System.out.println(i);
    }



}
