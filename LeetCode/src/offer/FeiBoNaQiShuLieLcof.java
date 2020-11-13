package offer;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/13
 */
public class FeiBoNaQiShuLieLcof {
    /**
     * 剑指 Offer 10- I. 斐波那契数列
     */
    /**
     * 尝试使用递归发现超时，采用动态规划，当n=0时，返回0，n=1时返回1，所以使用a，b分别代表
     * n=0和1的返回值，k代表当前n=i+1的返回值,也就是最终的返回值 k = b + a相当于
     * f(n) = f(n-1) + f(n-2) n > 1
     */
    public static int fib(int n) {
        int a = 0, b = 1, k = a;
        for (int i = 0; i < n; i++) {
            a = b;
            b = k;
            k = (a + b) % 1000000007;
        }
        return k;
    }

    public static void main(String[] args) {

        System.out.println(fib(50));
    }
}
