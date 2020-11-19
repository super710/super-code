package algorithms;

import java.util.ArrayList;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/18
 */
public class RegularExpressionMatching {

    /**
     * 10. 正则表达式匹配
     */

    /**
     * 穷举，从前往后看，试图穷举所有情况，发现有些情况确实很难处理，最后388 / 447 个通过测试用例，太难了
     */

    public static boolean isMatch(String s, String p) {
        int length = p.length();
        int length1 = s.length();
        if (s.equals(p)) {
            return true;
        } else if (!p.contains("*")) {
            if (length != length1) {
                return false;
            }
            for (int i = 0; i < length1; ++i) {
                if (s.charAt(i) != p.charAt(i) && '.' != p.charAt(i)) {
                    return false;
                }
            }
            return true;
        } else if (".*".equals(p)) {
            return true;
        } else {
            ArrayList<Integer> num = new ArrayList<>();
            if (!p.contains(".")) {
                char[] chars = p.toCharArray();
                for (int i = 0; i < length; ++i) {
                    if (p.charAt(i) == '*') {
                        num.add(i);
                    }
                }
                for (Integer i : num) {
                    int a = i + 1;
                    char c = p.charAt(i - 1);
                    for (; a < p.length(); a++) {
                        if (c != p.charAt(a)) {
                            a--;
                            break;
                        }
                        if (a == length - 1) {
                            break;
                        }
                    }
                    if (a >= length) {
                        break;
                    }
                    if (p.charAt(a) == c) {
                        chars[i] = c;
                        chars[a] = '*';
                    }
                }
                p = new String(chars);
            }
            int j = 0;
            int b;
            here:
            for (int i = 0; i < length1; i++) {
                if (j >= length) {
                    return false;
                }
                b = j;
                for (; j < length; j++) {
                    if (j > 0 && p.charAt(j - 1) == '.' && p.charAt(j) == '*') {
                        j++;
                        break here;
                    }
                    while (i >= 0 && i < length1 && '*' == p.charAt(j) && (p.charAt(j - 1) == s.charAt(i) || (p.charAt(j - 1) == '.' && s.charAt(i) == s.charAt(i - 1)))) {
                        i++;
                    }
                    if ('*' == p.charAt(j)) {
                        b = j + 1;
                    }
                    if (i == length1) {
                        break;
                    }
                    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                        if ((j - b) % 2 != 0) {
                            return false;
                        }
                        for (int k = b + 1; k < j; k += 2) {
                            if ('*' != p.charAt(k)) {
                                return false;
                            }
                        }
                        j++;
                        break;
                    }
                }
            }
            if (j == length) {
                if (s.charAt(length1 - 1) == p.charAt(length - 1) || p.charAt(length - 1) == '*' || p.charAt(length - 1) == '.') {
                    return true;
                }
                return false;
            } else if ((j - length) % 2 != 0) {
                if (p.charAt(j) != '*') {
                    return false;
                }
                j++;
            }
            for (int k = j + 1; k < length; k += 2) {
                if ('*' != p.charAt(k)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 动态规划，从后往前看，罗列所有的情况
     */
    public static boolean isMatch1(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        //两个空字符串认为匹配
        dp[0][0] = true;
        //s为空，p都是字符+*的，可以匹配
        for (int i = 1; i < n + 1; i++) {
            if (p.charAt(i - 1) == '*'){
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*'){
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'){
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    }else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("mississippi", "mis*is*p*."));
        System.out.println(isMatch1("mississippi", "mis*is*p*."));
    }
}
