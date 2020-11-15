package offer;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/15
 */
public class QingWaTiaoTaiJieWenTiLcof {

    /**
     * 剑指 Offer 10- II. 青蛙跳台阶问题
     */

    /**
     * 使用动态规划，和斐波那契数列一样，不过这次是f(n-2) = f(n) + f(n-1)，即 k = a + b;
     * a 代表当前有多少种跳法
     */

    public static int numWays(int n) {
        int a = 1, b = 1, k = 2;
        for (int i = n; i > 0; --i){
            a = b;
            b = k;
            k = (a + b) % 1000000007;
        }
        return a;
    }

    public static void main(String[] args) {

        System.out.println(numWays(100));
    }
}
