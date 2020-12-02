package offer;

import java.util.Arrays;

/**
 * @Author cy
 * @Description
 * @Date 2020/12/2
 */
public class ShunShiZhenDaYinJuZhenLcof {

    /**
     * 剑指 Offer 29. 顺时针打印矩阵
     */

    /**
     * 从左上角开始顺时针先往右再往下，然后判断是否存在未遍历的行数决定是否往左
     * 遍历，再判断是否存在为遍历的列决定是否往上遍历
     */

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int rowStart = 0;
        int colStart = 0;
        int[] res = new int[row * col];
        int n = 0;
        while (rowStart < row && colStart < col) {
            for (int i = colStart; i < col; ++i) {
                res[n++] = matrix[rowStart][i];
            }
            for (int i = rowStart + 1; i < row; ++i) {
                res[n++] = matrix[i][col - 1];
            }
            if (rowStart < row - 1) {
                for (int i = col - 2; i >= colStart; --i) {
                    res[n++] = matrix[row - 1][i];
                }
            }
            if (colStart < col - 1) {
                for (int i = row - 2; i > rowStart; --i) {
                    res[n++] = matrix[i][colStart];
                }
            }
            col--;
            colStart++;
            row--;
            rowStart++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}})));
    }
}
