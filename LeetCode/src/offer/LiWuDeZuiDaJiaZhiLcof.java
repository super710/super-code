package offer;

/**
 * @Author cy
 * @Description
 * @Date 2021/3/8
 */
public class LiWuDeZuiDaJiaZhiLcof {

    /**
     * 剑指 Offer 47. 礼物的最大价值
     */

    /**
     * 动态规划，计算到【i，j】路径的礼物最大值
     */

    public static int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                } else if (j == 0 && i > 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else if (j > 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxValue(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}