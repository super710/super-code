/**
 * @author Tiger
 * @date 2020/11/10 17:01
 */
public class Day01_FibonacciNumber {
    /**
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 给定 N，计算 F(N)
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solution_1(10));
        System.out.println(solution_2(10));
    }

    private static int solution_1(int n) {
        //递归实现  效率较低  O(2^n)
        if (n <= 1) {
            return n;
        } else {
            return solution_1(n - 1) + solution_1(n - 2);
        }
    }

    private static int solution_2(int n) {
        int i = 0;
        int j = 1;
        //O(n)
        for (int m = 0; m < n - 1; m++) {
            int num = i + j;
            i = j;
            j = num;
        }
        return j;
    }
}
