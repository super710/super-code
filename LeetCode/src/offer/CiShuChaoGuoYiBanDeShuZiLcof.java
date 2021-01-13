package offer;

/**
 * @Author cy
 * @Description
 * @Date 2021/1/13
 */
public class CiShuChaoGuoYiBanDeShuZiLcof {

    /**
     * 剑指 Offer 39. 数组中出现次数超过一半的数字
     */

    /**
     * 使用摩尔投票法，如果相同就加1，不同就减1，最后大于0则输出那个数字
     */
    public static int majorityElement(int[] nums) {
        int num = nums[0];
        int i = 0;
        int sum = 0;
        while (i < nums.length){
            if (num == nums[i++]){
                sum++;
            } else {
                sum--;
            }
            if (sum <= 0){
                num = nums[i];
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
}
