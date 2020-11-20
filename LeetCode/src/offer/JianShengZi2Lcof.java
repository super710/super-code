package offer;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/20
 */
public class JianShengZi2Lcof {

    /**
     * 剑指 Offer 14- II. 剪绳子 II
     */

    /**
     * 根据数学知识，每段为3的时候乘积最大，但可以会超过int的限制，所以每次乘3后对
     * 1000000007取模，但1000000007*3也超过int32的限制，所有选用long类型
     */

    public static int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        }
        long max = 1;
        while (n > 4) {
            max = max * 3 % 1000000007;
            n -= 3;
        }
        return (int) (max * n % 1000000007);
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(127));
    }
}
