package offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/11
 */
public class ShuZuZhongChongFuDeShuZiLcof {

    /**
     * 剑指 Offer 03. 数组中重复的数字
     */

    /**
     * 使用HashSet无法存储相同的元素的特性，遍历数组加入set，当加入元素set大小不变时说明元素重复
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        Set<Integer> temp = new HashSet<>();
        //上次的set集合大小
        int num = 0;
        for(int i : nums){
            num = temp.size();
            temp.add(i);
            //判断是否加入成功
            if(num == temp.size()){
                return i;
            }
        }
        return -1;
    }

    
    public static void main(String[] args) {

        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
