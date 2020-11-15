package algorithms;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/15
 */
public class LongestPalindromicSubstring {

    /**
     * 5. 最长回文子串
     */

    /**
     * 暴力法，重最长的字符串到单个字符开始遍历，如果出现回文字符串，直接返回
     */

    public static String longestPalindrome(String s) {
        int flag = 0;
        int n = s.length();
        int j = n;
        String s1;
        for (;;){
            for (int i = 0; i + j <= n; ++i){
                s1 = s.substring(i, i + j);
                int length = s1.length();
                if (length == 1){
                    return s1;
                }
                for (int k = 0; k < length / 2; ++k){
                    if (s1.charAt(k) != s1.charAt(length - 1 - k)) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0){
                    return s1;
                }
                flag = 0;
            }
            j--;
        }
    }

    /**
     * 动态规划
     */
    public static String longestPalindrome1(String s) {
        int n = s.length();
        int a = 0;
        int b = 0;
        int length = 1;
        boolean[][] dp = new boolean[n][n];
        for (int i = 1; i < n; ++i){
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)){
                    if (i - j < 3){
                        dp[j][i] = true;
                    } else if (dp[j + 1][i - 1]){
                        dp[j][i] = true;
                    }
                }
                if (dp[j][i] && i - j + 1 > length){
                    a = j;
                    b = i;
                    length = i - j + 1;
                }
            }
        }
        return s.substring(a, b + 1);
    }

    /**
     * 中心扩散法
     */

    public static String longestPalindrome2(String s) {

        int n = s.length();
        String maxS = s.substring(0, 1);
        if (n < 2){
            return maxS;
        }
        for (int i = 0; i < n - 1; i++) {
            String s1 = center(s, i, i);
            String s2 = center(s, i, i + 1);
            String s3 = s1.length() > s2.length() ? s1 : s2;
            maxS = maxS.length() < s3.length() ? s3 : maxS;
        }
        return maxS;
    }
    static String center(String s, int start, int end){
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babcdefgfedca"));
        System.out.println(longestPalindrome1("cabcdefgfedca"));
        System.out.println(longestPalindrome2("aabcdefgfedca"));
    }
}
