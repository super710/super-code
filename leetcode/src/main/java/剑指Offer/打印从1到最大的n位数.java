package 剑指Offer;

import java.util.Arrays;

/**
 * @author Tiger
 * @date 2020/11/30 10:18
 */
public class 打印从1到最大的n位数 {
//    public int[] printNumbers(int n) {
//        int l = (int) (Math.pow(10, n) - 1);
//        int[] ints = new int[l];
//        for (int i = 0; i < l; i++) {
//            ints[i] = i + 1;
//        }
//        return ints;
//    }
//    public int[] printNumbers(int n) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < n; i++) {
//            sb.append('9');
//        }
//        int integer = Integer.parseInt(sb.toString());
//        int[] ints = new int[integer];
//        for (int i = 1; i <= integer; i++) {
//            ints[i - 1] = i;
//        }
//        return ints;
//    }

    static  char[] num;
    static int[] ans;
    static  int count = 0;
   static int m;
    public static int[] printNumbers(int n) {
        m = n;
        num = new char[n];
        ans = new int[(int) (Math.pow(10, n) - 1)];
        dfs(0);
        return ans;
    }
    private static void dfs(int n) {
        if (n == m) {
            String tmp = String.valueOf(num);
            int curNum = Integer.parseInt(tmp);
            if (curNum!=0) ans[count++] = curNum;
            return;
        }
        for (char i = '0'; i <= '9'; i++) {
            num[n] = i;
            dfs(n + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers(2)));
    }
}
