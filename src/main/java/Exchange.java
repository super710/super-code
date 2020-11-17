/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */

public class Exchange {
    public static int[] exchange(int[] nums) {
       /* 我的思路：n%2==0偶数
       * 定义首尾指针，首指针是偶数的情况与尾指针是奇数的情况调换。
       * 直到首尾指针相等则停止遍历
       * */
       /* int pointStart = 0;
        int pointEnd = nums.length-1;
        int swap =0;

        while(pointStart<=pointEnd){

            if((nums[pointStart]&1)==0&&(nums[pointEnd]&1)!=0) {
                swap = nums[pointStart];
                nums[pointStart]=nums[pointEnd];
                nums[pointEnd]=swap;
            }else {
                if((nums[pointStart] & 1)!=0)
                    pointStart++;
                if((nums[pointEnd]&1)==0)
                    pointEnd--;
            }

        }*/

        //大神代码

                int i = 0, j = nums.length - 1, tmp;
                while(i < j) {
                    while(i < j && (nums[i] & 1) == 1) i++;
                    while(i < j && (nums[j] & 1) == 0) j--;
                    tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
                return nums;
            }







    public static void main(String[] args) {
        int nums[]={1,2,3,4,5,6,7};
        exchange(nums);
        for (int num : nums) {
            System.out.printf("%d",num);
        }
    }
}
