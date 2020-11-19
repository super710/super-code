package offer;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/19
 */
public class JianShengZiLcof {

    /**
     * 剑指 Offer 14- I. 剪绳子
     */

    /**
     * 根据数学知识，几个数的和一定时，数相同时乘积最大，
     * 但该题需要保证整数，所以在最后一个数分情况讨论
     */
    public static int cuttingRope(int n) {
        if (n < 4){
            return n - 1;
        }
        int nums;
        int max = 0;
        for (int i = 2; i < Math.sqrt(n) + 1; ++i){
            int m = n / i;
            if (n % i == 0){
                nums = (int) Math.pow(i , m);
            } else {
                nums = (int) Math.pow(i , m - 1) * (i + n % i);
                int num = (int) Math.pow(i , m) * (n % i);
                nums = Math.max(num, nums);
            }
            max = Math.max(max, nums);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(8));
    }
}
