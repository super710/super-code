package offer;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/23
 */
public class ShuZhiDeZhengShuCiFangLcof {

    /**
     * 剑指 Offer 16. 数值的整数次方
     */

    /**
     * 快速幂，
     * 当 n 为偶数： x^n = (x^2)^(n/2)
     * 当 n 为奇数： x^n = x(x^2)^(n/2)即会多出一项 x
     */

    public static double myPow(double x, int n) {
        double sum = 1;
        int m = n;
        while (n != 0){
            if (n % 2 != 0){
                sum = sum * x;
            }
            x = x * x;
            n /= 2;
        }
        return m > 0 ? sum : 1 / sum;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.10000, 3));
    }
}
