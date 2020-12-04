package 剑指Offer;

/**
 * @author Tiger
 * @date 2020/11/30 8:22
 */
public class 斐波那契数列 {
    //    public int fib(int n) {
//        if (n <= 1) {
//            return n;
//        } else {
//            return fib(n - 1) + fib(n - 2);
//        }
//    }

//    public int fib(int n) {
//        if (n <= 1) {
//            return n;
//        }
//        int a = 0;
//        int b = 1;
//        int temp;
//        for (int i = 1; i < n; i++) {
//            temp = (a + b) % 1000000007;
//            a = b % 1000000007;
//            b = temp;
//        }
//        return b;
//    }

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] ints = new int[n+1];
        ints[0] = 0;
        ints[1] = 1;

        for (int i = 2; i <= n; i++) {
            ints[i] = ints[i-1]  + ints[i - 2] ;
            ints[i] %= 1000000007;
        }

        return ints[n];

    }
}
