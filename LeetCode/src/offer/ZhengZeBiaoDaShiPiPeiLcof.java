package offer;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/24
 */
public class ZhengZeBiaoDaShiPiPeiLcof {

    /**
     * 剑指 Offer 19. 正则表达式匹配
     */

    /**
     * 动态规划，从后往前看，罗列所有的情况
     */

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        //s为空时的匹配情况
        for (int i = 2; i < n + 1; i = i + 2 ) {
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
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[m + 1][n + 1];
    }
}
