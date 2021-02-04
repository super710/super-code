package Matrix;

import org.junit.Test;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，
 * 每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，
 * 并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 *
 */
public class MaxValue {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //dp表示走到该单元格时总的价值收益
        int[][] dp=new int[m][n];//优化空间，可用grid直接代替dp
        dp[0][0]=grid[0][0];

        for(int i =0;i<grid.length;i++){
            for (int j =0;j<grid[0].length;j++){
                if(i==0&&j==0) continue;//优化时间，为了避免冗余的0判断，先初始化0行列再遍历直接赋值。
                if(i==0) dp[i][j]=dp[i][j-1]+grid[i][j];
                if(j==0) dp[i][j]=dp[i-1][j]+grid[i][j];

                if(i!=0&&j!=0){
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j])+grid[i][j];
                }

            }
        }
        return dp[m-1][n-1];
    }

    /**
     *  public int maxValue(int[][] grid) {
     *         int m = grid.length, n = grid[0].length;
     *         for(int j = 1; j < n; j++) // 初始化第一行
     *             grid[0][j] += grid[0][j - 1];
     *         for(int i = 1; i < m; i++) // 初始化第一列
     *             grid[i][0] += grid[i - 1][0];
     *         for(int i = 1; i < m; i++)
     *             for(int j = 1; j < n; j++)
     *                 grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
     *         return grid[m - 1][n - 1];
     *     }
     */

    @Test
    public void test(){
        int[][] grid= new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 1, 2}};
        System.out.println(maxValue(grid));
    }
}
