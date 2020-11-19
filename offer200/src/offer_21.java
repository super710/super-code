/**
 * @Author Jinshihong
 * @Date 2020/11/19 9:31
 * @Version 1.0
 */
public class offer_21 {

    public static void main(String[] args) {
        offer_21 o=new offer_21();
        int nums[]={1,3,5};
        System.out.println(o.exchange(nums));
    }

    public int[] exchange(int[] nums) {
        int  start=0;
        int end=nums.length-1;

        while (start<end) {
            while (nums[start] % 2 != 0&&start<end) start++;
            while (nums[end] % 2 == 0&&end>start) end--;
            int t=nums[start];
            nums[start]=nums[end];
            nums[end]=t;


        }

        return nums;

    }

}
