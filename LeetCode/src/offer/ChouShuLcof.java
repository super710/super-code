package offer;

import java.net.DatagramPacket;

/**
 * @Author cy
 * @Description
 * @Date 2021/3/18
 */
public class ChouShuLcof {

    /**
     * 剑指 Offer 49. 丑数
     * 我们把   <只包含>   质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
     */

    /**
     * 动态规划，使用三个指针a，b，c，分别代表当前的丑数乘没乘过 2  3  5，如果乘过，对应的
     * 指针加1（因为每个丑数只会分别乘以2 3 5一次，得到另外的丑数）用三个指针是为了排序
     */

    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[a] * 2, dp[b] * 3), dp[c] * 5);
            if (dp[i] == dp[a] * 2){
                a++;
            }
            if (dp[i] == dp[b] * 3){
                b++;
            }
            if (dp[i] == dp[c] * 5){
                c++;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(11));
    }
}
